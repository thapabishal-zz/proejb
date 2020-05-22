package org.proejb.web.view;

import org.proejb.inf.bean.UserServiceBeanRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class UserServiceRest {

    @Autowired
    private UserServiceBeanRemote userServiceBeanRemote;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete() throws InterruptedException, ExecutionException, TimeoutException {

        Future<String> future = userServiceBeanRemote.deleteUser(10);
        String result = future.get(3000, TimeUnit.MILLISECONDS);
        return result;
    }

}
