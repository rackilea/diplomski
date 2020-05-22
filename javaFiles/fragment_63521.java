public class TheClassWhereYouAreCreatingTheObject {

    @Autowired
    private ApplicationContext context;                  // You definitely need this

    public void theMethodWhereYouAreCreatingTheObject() {
         Class<?> clazz = ...                            // getting the object class
         Object instance = context.getBean(clazz);     // getting and instance trough Spring

         // If you know that kind of object you will get cast it at call its methods
         ((Specific) instance).run();

         // If you know anything about the class you will have to use reflection
         Method method = clazz.getMethod("run", new Class[]{});
         method.invoke(instance, new Object[]{});
    }
}