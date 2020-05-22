vertx.deployVerticle(TestService.class.getName(), deployment -> {
  if (deployment.succeeded()) {
    // here is your ID
    String deploymentId = deployment.result();
  } else {
    // deployment failed...
  }
});