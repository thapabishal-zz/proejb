package org.proejb.integration.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ContextUtils {

    private Context context;
    private static ContextUtils contextUtils;

    private ContextUtils(Properties initContextProperties) throws NamingException {
        context =  new InitialContext(initContextProperties);
    }


    public static ContextUtils getInstance() {
        if (contextUtils==null) {
            try {
                contextUtils = new ContextUtils(getProperties());
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return contextUtils;
    }


    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        properties.put(Context.PROVIDER_URL,"t3://localhost:7001");
        return properties;
    }


/*   For Wildfly properties
    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");

        return properties;
    }*/

    public Object lookupRemote(String jndiName) {
        Object object = null;
        try {
            object = context.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return object;
    }
}
