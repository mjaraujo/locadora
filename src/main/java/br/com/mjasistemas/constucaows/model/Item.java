/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Marcio
 */
@Entity
public class Item extends Entidade{

    private Double preco;
    private Double quantidadeEstoque;
    @Id
    private Long ID;

    public Item() {
    }

    public Item(Double preco, Double quantidadeEstoque) {
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    
    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidadeEstoque
     */
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
