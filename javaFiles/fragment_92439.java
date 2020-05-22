public class MyInterceptor extends EmptyInterceptor {

    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
        if(entityName.equals(Foo.class.getName())
             return Foo.create();
        return null;
    }
}