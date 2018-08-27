/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.rest;

import br.com.mjasistemas.constucaows.rest.impl.estabelecimento.EstabelecimentoResponse;
import br.com.mjasistemas.constucaows.rest.service.EstabelecimentoService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marcio
 */
@Path("/estabelecimento")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EstabelecimentoResource {

    private EstabelecimentoService estabelecimentoService = new EstabelecimentoService();
    
    @Context
    HttpServletRequest request;

   
    @GET
    @Path("{id}")
    @Produces("application/json")
    public EstabelecimentoResponse get(@PathParam("id") Integer id) {
            
        EstabelecimentoResponse response = estabelecimentoService.getById(id);        
        return response;
    }

}
