class Parent{
    public static HashMap<Class<? extends Parent>, Parent> instance 
                  = new HashMap<Class<? extends Parent>, Parent>();
    protected Parent(){}
    public static <T> T getInstance(Class<? extends Parent> cls) 
                    throws InstantiationException, IllegalAccessException{
        if (instance.get(cls) == null) {
            instance.put(cls, cls.newInstance());
        }
        return (T)instance.get(cls);
    }
}

class Child extends Parent{
    protected Child(){

    }
}

Child child = Child.getInstance(Child.class);