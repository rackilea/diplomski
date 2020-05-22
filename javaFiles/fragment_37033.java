package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.MappedSuperclass;

import play.Logger;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;

@MappedSuperclass
public abstract class GenericDictionary<T extends Generic<T>> extends Generic<T> {

    @Required
    public String name;
    @Required
    public boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean stat) {
        this.active = stat;
    }
    /**
     * Options.
     *
     * @return the map
     */
    public Map<String, String> getOptions() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (T e : getList()) {
            GenericDictionary entity = (GenericDictionary) e;
            options.put(e.id.toString(), entity.name);
        }
        return options;
    }
//  @Override
//  public List<GenericDictionary> getList() {
//      return (List<GenericDictionary>) JPA.em().createQuery("FROM " + entityClass.getSimpleName()).getResultList();
//  }

    public void on() {
        this.active = true;
        update();       
    }

    public void off() {
        this.active = false;
        update();       
    }
}