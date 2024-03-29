package org.proejb.web.view;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.proejb.inf.bean.UserServiceBeanRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.jsp.PageContext;
import javax.xml.ws.Response;


@Controller
@RequestMapping(name = "/")
public class HomeController {

    private static final Logger LOG = Logger.getLogger("HomeController");

    @Autowired
    private UserServiceBeanRemote userServiceBeanRemote;

    @GetMapping
    public String loadIndexPage() {
        LOG.info( userServiceBeanRemote.getUser(0).getLastName() );
        return "index";
    }

}
