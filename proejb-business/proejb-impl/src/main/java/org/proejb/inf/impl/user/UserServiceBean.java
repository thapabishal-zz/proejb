package org.proejb.inf.impl.user;

import org.apache.log4j.Logger;
import org.proejb.inf.bean.UserServiceBeanRemote;
import org.proejb.inf.dto.UserDto;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.concurrent.Future;

@Stateless(name = UserServiceBeanRemote.BEAN_NAME)
public class UserServiceBean implements UserServiceBeanRemote {

    private static final Logger LOG = Logger.getLogger("UserServiceBean");


    public UserDto getUser(long id) {
        UserDto dto = new UserDto();
        dto.setFirstName("Bishal");
        dto.setLastName("Thapa");
        dto.setAge(23);
        dto.setDateOfBirth(LocalDate.of(1997, 8, 24));

        LOG.info("Found user "+dto.getName()+" of id "+id);

        return dto;
    }

    @Asynchronous
    @Override
    public Future<String> deleteUser(long id) throws InterruptedException {
        Thread.sleep(4000);
        return new AsyncResult<String>("Wait is over");
    }
}
