package org.example.customer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.Path;

import org.eclipse.persistence.rest.JPASingleKeyResource;

@Stateless
@LocalBean
@Path("/customers")
public class CustomerService  {

    @PersistenceContext(unitName="CustomerService", type=PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

}