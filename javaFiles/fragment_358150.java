package com.yigit.camp.api;
public class MyAppConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();        
        classes.add(CORSResponseFilter.class);        
        return classes;
    }
}