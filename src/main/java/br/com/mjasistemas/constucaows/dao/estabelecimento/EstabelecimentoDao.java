/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.dao.estabelecimento;

import br.com.mjasistemas.constucaows.dao.GenericDAO;
import br.com.mjasistemas.constucaows.model.Estabelecimento;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author Marcio
 */
public class EstabelecimentoDao extends GenericDAO<Estabelecimento> {

    public Estabelecimento getById(Integer id) {
        addParams("id", id);
        return (Estabelecimento) newQueryBuilder("Estabelecimento.findById").get(0);
    }

}
