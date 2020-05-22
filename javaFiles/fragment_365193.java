package de.professional_webworkx.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import de.professional_webworkx.model.entities.Item;

/**
 * this is our stateless session bean which does all the database work,
 * e.g. send queries to the database and give results back to the calling
 * class(es)...
 * @author ottp
 *
 */
// in this SessionBean you can implement your business logic and 
// fill a list or a object and give it to the webservice class by 
// getter methods...
@Stateless
public class ItemsBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5684254200888793061L;
    private List<Item> items = new ArrayList<Item>();

    public ItemsBean() {

    }

    @PostConstruct
    public void init() {
        for(int i = 0; i < 1000; ++i) {
            items.add(new Item("Item_"+i, Math.random()*i, (int) i*i));
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}