package com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JAXBContextFactory {

    private static JAXBContext context = null;
    public static synchronized JAXBContext createJAXBContext() throws JAXBException {
        if(context == null){
            context = JAXBContext.newInstance(Customer.class);
        }
        return context;
    }

}