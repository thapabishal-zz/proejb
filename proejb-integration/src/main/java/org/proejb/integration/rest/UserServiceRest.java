package org.proejb.integration.rest;

import org.apache.log4j.Logger;
import org.proejb.inf.bean.UserServiceBeanRemote;
import org.proejb.inf.dto.UserDto;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserServiceRest {

    private static final Logger LOG = Logger.getLogger("UserServiceRest");

    @EJB(mappedName = UserServiceBeanRemote.BEAN_NAME)
    private UserServiceBeanRemote useServiceRemote;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public UserDto getUserDto(@PathParam("id") long id)  {
        LOG.info("Get user with id = "+id);
        UserDto userDto = useServiceRemote.getUser(id);
        return userDto;
    }
}
