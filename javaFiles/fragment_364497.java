public class ServiceContainer {
 HashMap<Class, Object> services;

 public ServiceContainer() {
     services = new HashMap<Class, Object>();
 }

 public <T> void addService(Class<T>, T object) {
     services.put(t, object);
 }
 public <T> void addService(T object) {
     Class type = object.getClass();
     services.put(type, object);
 }
}