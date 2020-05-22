package com.buzzy.jersey.provider;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.ClassUtils;

import uk.co.froot.demo.openid.model.security.Authority;

/**
 * @author Sanjay Patel (sanjaypatel at ibm.com)
 */
@Provider
public class FilterResponseFilter implements ContainerResponseFilter {

@Context
private ResourceInfo resourceInfo;
@Context
private HttpServletRequest request;

@Override
public void filter(ContainerRequestContext requestContext,
        ContainerResponseContext responseContext) throws IOException {
    if(responseContext.getEntity()!=null)
        filterObject(((Authority)request.getAttribute("hasAuthority")),responseContext.getEntity());
}

private void filterObject(Authority auth, Object entity) {
    if(entity instanceof List) {
        for(Object  obj: (List)entity)filterObject(auth,obj);
    }
    else if(entity instanceof Map) {
        for(Object obj : ((Map)entity).values()) filterObject(auth,obj);
    }
    else if(entity instanceof Object[]){
        for(Object  obj: (Object[])entity)filterObject(auth,obj);
    }
    else if(!ClassUtils.isPrimitiveOrWrapper(entity.getClass()) && !(entity instanceof String)){
        try{
            for(Method method:entity.getClass().getMethods()){
                if(method.getName().startsWith("get") && !method.getName().equals("getClass")){
                    String fieldName = method.getName().substring(3);
                    fieldName=fieldName.substring(0, 1).toLowerCase()+fieldName.substring(1, fieldName.length());
                    Field field = entity.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    if(method.getAnnotation(DenyAll.class)!=null ){
                        field.set(entity, null);
                    }
                    if(method.getAnnotation(RolesAllowed.class)!=null){
                        if(auth!=null && Arrays.asList(method.getAnnotation(RolesAllowed.class).value()).contains(auth.name())){
                            if(!ClassUtils.isPrimitiveOrWrapper(method.getReturnType()) && !(entity instanceof String)){
                                filterObject(auth, field.get(entity));
                            }
                        }
                        else{
                            field.set(entity, null);
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
}