// In your jersey method
    final EntityTag eTag = new EntityTag(resource.getId() + "_" +
     resource.getLastModified().getTime());
    final CacheControl cacheControl = new CacheControl();
    cacheControl.setMaxAge(-1);

    ResponseBuilder builder = request.evaluatePreconditions(
         resource.getLastModified(), eTag);

    // the resoruce's information was modified, return it
    if (builder == null) {
         builder = Response.ok(resource);
    }

    // the resource's information was not modified, return a 304

    return builder.cacheControl(cacheControl).lastModified(
         resource.getLastModified()).tag(eTag).build();