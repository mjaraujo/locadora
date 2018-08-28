/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Giuvane
 */
public class GenericDAO<T> implements iGenericDAO<T>, Serializable {

    EntityManager manager;
    private Queue<String> params;
    private Queue<Object> values;

    public GenericDAO() {
        this.manager = ConexaoHibernate.getConnection();
        this.params = new LinkedList();
        this.values = new LinkedList();
    }

    public void commit() {
        manager.getTransaction().commit();
    }

    @Override
    public void save(T object) {

        try {

            manager.getTransaction().begin();
            //Object o = manager.merge(object);
            manager.persist(object);
            manager.getTransaction().commit();

            System.out.println(object.getClass().getSimpleName() + " salvo som sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }

    }

    @Override
    public T listOne(String pkName, int pkValue, Class clazz) {
        String jpql = " SELECT t FROM " + clazz.getTypeName() + " t where t." + pkName + " = " + pkValue;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }

    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = " SELECT t FROM " + clazz.getTypeName() + " t where t." + pkName + " = " + pkValue;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (T) obj;
    }

    @Override
    public List listAll(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(T object) {
        try {
            manager.getTransaction().begin();
            Object o = manager.merge(object);
            manager.persist(o);
            manager.flush();
            manager.getTransaction().commit();
            System.out.println(object.getClass().getSimpleName() + " atualizado som sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(T object, boolean flushes) {
        try {
            EntityTransaction entr = manager.getTransaction();
            if (entr.isActive()) {
                manager.getTransaction().commit();
            }
            manager.getTransaction().begin();
            Object o = manager.merge(object);
            manager.persist(o);
            manager.flush();
            manager.getTransaction().commit();
            System.out.println(object.getClass().getSimpleName() + " atualizado som sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }

    public void refresh(T object) {
        T merge = manager.merge(object);
        manager.refresh(merge);
        System.out.println("Refresh executado");
    }

    @Override
    public void delete(T object) {
        manager.getTransaction().begin();
        Object o = manager.merge(object);
        manager.remove(o);
        manager.getTransaction().commit();
        System.out.println(object.getClass().getSimpleName() + " excluído Com sucesso!");
    }

    @Override
    public List listAll(Class clazz) {
        String jpql = " SELECT t FROM " + clazz.getTypeName() + " t";
        Query query = manager.createQuery(jpql);
        List<T> objects = query.getResultList();
        return objects;
    }

    public void addParams(String parametro, Object valor) {
        params.add(parametro);
        values.add(valor);
    }

    public List newQueryBuilder(String query) {

        List<T> objects;
        Query createNamedQuery = manager.createNamedQuery(query);
        while (params.size() > 0) {
            createNamedQuery.setParameter(params.poll(), values.poll());
        }
        objects = createNamedQuery.getResultList();
        return objects;
    }

}
