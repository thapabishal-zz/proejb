package org.proejb.integration.utils;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class EjbIntegrationWebInjectResolver implements InjectionResolver<EJB> {

    private static final String JNDI_BINDING_PREFIX = "ejb:proejb-ear-1.0/org.proejb-proejb-impl-1.0/";

    public Object resolve(Injectee injectee, ServiceHandle<?> serviceHandle) {
        Object bean = null;
        try {
            Class beanClass = (Class) injectee.getRequiredType();
            String jndiName = JNDI_BINDING_PREFIX + beanClass.getSimpleName() + "!" + beanClass.getName();
            bean = ContextUtils.getInstance().lookupRemote(jndiName);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return bean;
    }

    public boolean isConstructorParameterIndicator() {
        return false;
    }

    public boolean isMethodParameterIndicator() {
        return false;
    }
}
