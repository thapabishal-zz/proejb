package org.proejb.inf.bean;

import org.proejb.inf.dto.UserDto;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface UserServiceBeanRemote {

    String BEAN_NAME = "UserServiceBeanRemote";

    UserDto getUser(long id);

    Future<String> deleteUser(long id) throws InterruptedException;

}
