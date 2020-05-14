package org.proejb.integration.utils;

import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ejb.EJB;
import javax.inject.Singleton;


public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(EjbIntegrationWebInjectResolver.class).to(new TypeLiteral<InjectionResolver<EJB>>() {
                }).in(Singleton.class);
            }
        });

    }
}
