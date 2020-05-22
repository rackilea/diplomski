public class PropertyProducer {

     @Produces
     public String createProperty(InjectionPoint injectionPoint) {
         String value =injectionPoint.getAnnotation(SystemProperty.class).value();
         return System.getProperty(value);
     }
}