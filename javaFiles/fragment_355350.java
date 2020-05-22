package org.example;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;

@Stateless
@LocalBean
@EJB(name = "someName", beanInterface = CustomerService.class)
public class OtherSessionBean {

    public Customer read(long id) {
        try {
            Context ctx = new InitialContext();
            CustomerService customerService = (CustomerService) ctx.lookup("java:comp/env/someName");
            return customerService.read(id);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}