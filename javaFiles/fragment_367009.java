String key = ""; // Such as /gs/example-bucket/categories/animals.png"
ImagesService images = ImagesServiceFactory.getImagesService();
BlobstoreService blobstore = BlobstoreServiceFactory.getBlobstoreService();
BlobKey blobKey = blobstore.createGsBlobKey(key);
ServingUrlOptions opts = ServingUrlOptions.Builder.
        withBlobKey(blobKey).
        secureUrl(true);
return images.getServingUrl(opts);