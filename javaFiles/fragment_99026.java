// BeforeInterceptor
message.put("com.example.MyApp.startTime", System.currentTimeMillis());

// AfterInterceptor
long totalTime = System.currentTimeMillis() -
   (Long)message.get("com.example.MyApp.startTime");