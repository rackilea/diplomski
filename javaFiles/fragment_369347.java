router.post("/api/end_point_1").handler(req -> {
   // Extract data from request
   // Package it into an object

   // Send it over EventBus
   vertx.eventBus().send("event1", data);
});