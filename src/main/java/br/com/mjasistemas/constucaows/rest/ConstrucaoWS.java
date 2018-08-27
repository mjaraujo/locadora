/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mjasistemas.constucaows.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;





/**
 *
 * @author marcio
 */
public class ConstrucaoWS extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        // Suporte ao File Upload.
        singletons.add(new MultiPartFeature());
        return singletons;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        // Configura o pacote para fazer scan das classes com anotações REST.
        properties
                .put("jersey.config.server.provider.packages", "com.mjasistemas.autoq");
        return properties;
    }

}
