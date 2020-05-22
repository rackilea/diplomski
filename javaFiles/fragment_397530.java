package com.example.jaxrs;

import org.apache.log4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

@Provider
public class TransactionIdentifierRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        String siteCodeHeader = containerRequestContext.getHeaderString("Site-Code");

        if (siteCodeHeader != null) {
            MDC.put("siteCode", siteCodeHeader);
        } else {
            MDC.put("siteCode", "NULL");
        }
        MDC.put("transactionId", UUID.randomUUID().toString());

    }
}