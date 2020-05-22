package org.demojsf.samples.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped  
@ManagedBean(name = "greet")
public  class GreetBean {

    public String greet() {
        return "Greeting"   ;   
    }

}