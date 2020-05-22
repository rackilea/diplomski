// The constructor must be private to prevent external instantiation   
 private MqttHandler(){};
 // The public static method allowing to get the instance
 public static MqttHandler getInstance() {
     return MqttHandlerHolder.INSTANCE;
 }
     /** 
 * The static inner class responsible for creating your instance only on demand, 
 * because the static fields of a class are only initialized when the class
 * is explicitly called, this rule is also applicable to inner static class
 * So here INSTANCE will be created only when MqttHandlerHolder.INSTANCE will be called
 */
 private static class MqttHandlerHolder {
     private static final MqttHandler INSTANCE = new MqttHandler();
 }