vertx.executeBlocking(future -> {
  Profile profile = ProfileManager.FindProfile(username,lang);
  future.complete(profile);
}, false, res -> {
  if (res.failed()) {
    // handle error, sent 500 back, etc...
  } else {
    Profile profile = res.result();

    if(profile == null){
      ctx.request().response().putHeader("available","false");
      utils.sendResponseAndEnd(ctx.response(),400);
      return;
    }else{
      ctx.request().response().putHeader("available","true");
      utils.writeStringAndEnd(ctx, new Gson().toJson(profile));
    }
  }
});