package org.proejb.web.utils;

import org.proejb.inf.bean.UserServiceBeanRemote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Configuration
public class EjbBeanAutowireFactory {


    @Bean
    public UserServiceBeanRemote getBean(Context context) throws NamingException {
        return (UserServiceBeanRemote) context.lookup( getJNDIName(UserServiceBeanRemote.class) );
    }


    @Bean
    public Context context() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        return new InitialContext(properties);
    }


    private String getJNDIName(Class classType) {
        String moduleName = "ejb:proejb-ear-1.0/org.proejb-proejb-impl-1.0/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        return moduleName + beanName + "!" + viewClassName;
    }

}
