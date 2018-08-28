/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcio
 */
@Entity
@Table(name = "tb_estabelecimento", catalog = "construcao", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estabelecimento.findAll", query = "SELECT e FROM Estabelecimento e")
    , @NamedQuery(name = "Estabelecimento.findById", query = "SELECT e FROM Estabelecimento e WHERE e.id = :id")
    , @NamedQuery(name = "Estabelecimento.findByNome", query = "SELECT e FROM Estabelecimento e WHERE e.nome = :nome")
    , @NamedQuery(name = "Estabelecimento.findByCnpj", query = "SELECT e FROM Estabelecimento e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Estabelecimento.findByEndereco", query = "SELECT e FROM Estabelecimento e WHERE e.endereco = :endereco")})
public class Estabelecimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "endereco", nullable = false, length = 150)
    private String endereco;

    public Estabelecimento() {
    }

    public Estabelecimento(Integer id) {
        this.id = id;
    }

    public Estabelecimento(Integer id, String nome, String cnpj, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento other = (Estabelecimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
