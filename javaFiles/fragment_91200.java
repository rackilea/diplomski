package com.beingjavaguys.controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beingjavaguys.model.Model;
import com.beingjavaguys.model.Status;
import com.beingjavaguys.services.GenericServices;

@Controller
public abstract class AbstractRest<T extends Model, I extends GenericServices<T>> {

    @Autowired
    I services;
    static final Logger logger = Logger.getLogger(AbstractRest.class);

    public AbstractRest() {
        super();
        Type kind = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) kind;
        this.setEntityClass(clazz);
    }

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    private T converter(Object t)
            throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException,IllegalArgumentException {
        if (entityClass.isInstance(t))
            return (T) t;
        LinkedHashMap<String, Object> c = ((LinkedHashMap<String, Object>) t);
        T entity = entityClass.newInstance();
        Class<?> clazz = entity.getClass();
        for (String key : c.keySet()) {
            try {
                Field field = clazz.getDeclaredField(key);

                field.setAccessible(true);

                Object value = c.get(key);
                if (Integer.class.isAssignableFrom(field.getType())) {
                    value = Integer.valueOf(((Number) value).intValue());
                } else if (Double.class.isAssignableFrom(field.getType())) {
                    value = Double.valueOf(((Number) value).doubleValue());
                } else if (Long.class.isAssignableFrom(field.getType())) {
                    value = Long.valueOf(((Number) value).longValue());
                } else if (Float.class.isAssignableFrom(field.getType())) {
                    value = Float.valueOf(((Number) value).floatValue());
                } 
                field.set(entity, value);
            } catch (Exception e) {
                logger.error("Entity does not have this atribute " + key + "! Returning entity without this.");
            }
        }
        return entity;
    }

    @RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public @ResponseBody Status<T> addEntity(@RequestBody Object t) throws Exception {
        try {
            T entity = converter(t);

            if (services.addEntity(entity)) {
                return new Status<T>(1, "Entity added Successfully!", entity);
            } else {
                return new Status<T>(0, "Entity not added Successfully!", entity);
            }
        } catch (Exception e) {
            logger.error("Entity not added Successfully !", e);
            return new Status<T>(0, e.toString(), null);
        }
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Status<T> mergeEntity(@RequestBody Object t) throws Exception {
        try {
            T entity = converter(t);

            if (services.mergeEntity(entity)) {
                return new Status<T>(1, "Entity merged Successfully !", entity);
            } else {
                return new Status<T>(0, "Entity not merged Successfully !", entity);
            }
        } catch (Exception e) {
            logger.error("Entity not merged Successfully !", e);
            return new Status<T>(0, e.toString(), null);
        }
    }

    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Status<List<T>> getEntityList(@RequestBody Object t) throws Exception {
        try {
            T entity = converter(t);
            List<T> entityList = services.getEntityList(entity);
            if (entityList != null)
                return new Status<List<T>>(1, "Entities returned Successfully !", entityList);
            else
                return new Status<List<T>>(0, "Entities not returned Successfully !", entityList);
        } catch (Exception e) {
            logger.error("Entities not lited Successfully !", e);
            return new Status<List<T>>(0, e.toString(), null);
        }

    }

    @RequestMapping(value = "/apagar/{id}", method = RequestMethod.GET)
    public @ResponseBody Status<Boolean> deleteEntity(@PathVariable("id") long id) throws Exception {
        try {
            if (services.deleteEntity(id)) {
                return new Status<Boolean>(1, "Entity deleted Successfully !", true);
            } else {
                return new Status<Boolean>(0, "Entity not deleted Successfully !", false);
            }
        } catch (Exception e) {
            logger.error("Entity not deleted Successfully !", e);
            return new Status<Boolean>(0, e.toString(), false);
        }
    }

    @RequestMapping(value = "/obter/{id}", method = RequestMethod.GET)
    public @ResponseBody Status<T> getEntity(@PathVariable("id") long id) throws Exception {
        T entity = entityClass.newInstance();
        try {
            entity = services.getEntity(id);
            if (entity != null)
                if (entity.getId() == 0)
                    return new Status<T>(1, "Entity not found!", null);
                else
                    return new Status<T>(1, "Entity returned Successfully !", entity);
            else
                return new Status<T>(0, "Entity not returned Successfully !", entity);
        } catch (Exception e) {
            logger.error("Entity not returned Successfully !", e);
            return new Status<T>(0, e.toString(), entity);
        }

    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody Status<List<T>> getEntityList() throws Exception {
        List<T> entityList = new ArrayList<T>();
        try {
            entityList = services.getEntityList();
            if (entityList != null)
                return new Status<List<T>>(1, "Entities returned Successfully !", entityList);
            else
                return new Status<List<T>>(0, "Entities not returned Successfully !", entityList);
        } catch (Exception e) {
            logger.error("Entities not lited Successfully !", e);
            return new Status<List<T>>(0, e.toString(), entityList);
        }

    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}