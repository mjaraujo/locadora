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
public class Estabelecimento extends Entidade{

    @Id
    private Long ID;

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    private String Endereco;
    private String CNPJ;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
