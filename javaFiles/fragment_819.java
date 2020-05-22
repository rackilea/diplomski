// It must be static and final to prevent later modification
 private static final MqttHandler INSTANCE = new MqttHandler();
 // The constructor must be private to prevent external instantiation  
 private MqttHandler(){};
 // The public static method allowing to get the instance
 public static MqttHandler getInstance() {
     return INSTANCE;
 }