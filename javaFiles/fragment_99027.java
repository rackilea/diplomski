// BeforeInterceptor
inMessage.getExchange().put("com.example.MyApp.startTime", System.currentTimeMillis());

// AfterInterceptor
long totalTime = System.currentTimeMillis() -
   (Long)outMessage.getExchange().get("com.example.MyApp.startTime");