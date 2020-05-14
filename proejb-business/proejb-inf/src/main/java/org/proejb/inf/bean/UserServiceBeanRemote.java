package org.proejb.inf.bean;

import org.proejb.inf.dto.UserDto;

import javax.ejb.Remote;

@Remote
public interface UserServiceBeanRemote {

    String BEAN_NAME = "UserServiceBeanRemote";

    UserDto getUser(long id);

}
