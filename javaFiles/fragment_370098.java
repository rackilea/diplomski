public class ServiceUtils {

      private static Service service;

      private ServiceUtils() {}
      ...

      public static void setService(Service service) {
        this.service = service;
      }
    }

    public class ServiceConfigurer {
      private static Service service;

      private ServiceUtils() {}
      ...

      public void setService(Service service) {
        ServiceUtils.setService(service);
          }
    }