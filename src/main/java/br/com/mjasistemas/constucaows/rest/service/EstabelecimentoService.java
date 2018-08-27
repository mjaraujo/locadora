/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.rest.service;

import br.com.mjasistemas.constucaows.dao.EstabelecimentoDao;
import br.com.mjasistemas.constucaows.model.Estabelecimento;
import br.com.mjasistemas.constucaows.rest.impl.estabelecimento.EstabelecimentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcio
 */

public class EstabelecimentoService {
    
    private EstabelecimentoDao estabelecimentoDao = new EstabelecimentoDao();
    
    public EstabelecimentoResponse getById(Integer id){
        EstabelecimentoResponse response = new EstabelecimentoResponse();
        Estabelecimento estabelecimento = estabelecimentoDao.getById(id);
        response.setID(estabelecimento.getID());
        response.setNome(estabelecimento.getNome());
        response.setEndereco(estabelecimento.getEndereco());
        return response;
    }
}
