public class ByteBuddyTest {

  public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
      GenericInterceptor interceptor = new GenericInterceptor ();

      Class<?> clazz = new ByteBuddy()
        .subclass(BaseUser.class)
        .method(ElementMatchers.isDeclaredBy(BaseUser.class).and(ElementMatchers.isSetter()))
            .intercept(SuperMethodCall.INSTANCE.andThen(MethodDelegation.to(interceptor))))
        .make()
        .load(ByteBuddyTest.class.getClassLoader())
        .getLoaded();

      BaseUser user1 = (BaseUser) clazz.getConstructors()[0].newInstance();
      BaseUser user2 = (BaseUser) clazz.getConstructors()[0].newInstance();
      user1.setName("user1");
      user1.setPassword("password1");
      user2.setName("user2");
      user2.setPassword("password2");

      System.out.println(interceptor.getInterceptedValue("user1", "name"));
      System.out.println(interceptor.getInterceptedValue("user1", "password"));
      System.out.println(interceptor.getInterceptedValue("user2", "name"));
      System.out.println(interceptor.getInterceptedValue("user2", "password"));

      user1.setPassword("password2");
      user1.setPassword("password3");
  }

  public static class GenericInterceptor {
      private Map<String, Object> interceptedValuesMap = new HashMap();

      public void set(String obj, @This User user, @Origin Method setter) {
        // assume that user name is unique so we can use it as a key in values map.
        // or define equals/hashcode in GenericUser object and use it as a key directly
        String setterName = setter.getName();
        String propertyName = setterName.substring(3, setterName.length()).toLowerCase();
        String key = user.getName() + "_" + propertyName;

        System.out.println("Setting " + propertyName + " to " + obj);
        System.out.println("Previous value " + interceptedValuesMap.get(key));

        interceptedValuesMap.put(key, obj);
      }

    public Object getInterceptedValue(String userName, String fieldName) {
        return interceptedValuesMap.get(userName + "_" + fieldName);
    }
  }

  public static interface User {

      String getName();

      String getPassword();

  }

  public static class BaseUser implements User {

      @Override
      public String getName() {
          return name;
      }

      @Override
      public String getPassword() {
          return password;
      }

      public void setName(String name) {
          this.name = name;
      }

      public void setPassword(String password) {
          this.password = password;
      }

      private String name;
      private String password;

  }
}