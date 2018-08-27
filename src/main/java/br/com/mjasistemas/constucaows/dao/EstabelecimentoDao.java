/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.dao;

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
public class EstabelecimentoDao {

    private Estabelecimento estabelecimento;
    private final List<Estabelecimento> estabelecimentos;

    public EstabelecimentoDao() {
        estabelecimentos = new ArrayList<>();
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setID(1L);
        estabelecimento.setNome("MC Materiais de construção");
        estabelecimento.setEndereco("Rua das acácias 458");
        estabelecimento.setCNPJ("5163155151/0001-77");
        estabelecimentos.add(estabelecimento);
    }

    public Estabelecimento getById(Integer id) {
        Estabelecimento estabelecimento = null;        
        Optional<Estabelecimento> findFirst = estabelecimentos.stream().filter(item -> item.getID() == id.longValue()).findFirst();
        if(findFirst.isPresent()){
            estabelecimento = findFirst.get();
        }
        return estabelecimento;
    }

}
