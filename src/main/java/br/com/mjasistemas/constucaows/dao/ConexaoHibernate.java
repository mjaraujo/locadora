package br.com.mjasistemas.constucaows.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class ConexaoHibernate {

    @PersistenceUnit
    private static EntityManagerFactory factory;
    private volatile static EntityManager manager;

    //public static Connection connection = null; // manages connection
    private ConexaoHibernate() {
    }

    public static EntityManager getConnection() {
        if (manager == null) {
            synchronized (ConexaoHibernate.class) {
                if (manager == null) {
                    factory = Persistence.createEntityManagerFactory("construcaodb");
                    factory.getCache().evictAll();                    
                    manager = factory.createEntityManager();
                    manager.setFlushMode(FlushModeType.COMMIT);
                }
            }
        }
        return manager;
    }

}
