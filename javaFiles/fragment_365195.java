package de.professional_webworkx.ws.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.professional_webworkx.business.ItemsBean;
import de.professional_webworkx.model.entities.Item;

// this is the path for the items service class,
// here we will get some information about 
// the entity Item
@Path("/items")
public class ItemsService {

    @EJB
    private ItemsBean bean;

    @Path("/info")
    @GET
    public String info() {
        return "Welcome to the ItemsService";
    }

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Item> getAllItems() {
        return bean.getItems();
    }
}