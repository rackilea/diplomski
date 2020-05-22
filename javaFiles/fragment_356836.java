@ResponseBody
@RequestMapping(value = "/imageupload", method = RequestMethod.POST)
public void getUploadedImagesUrls(HttpServletRequest request){
    Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
    List<BlobKey> blobKeys = blobs.get("myFile[]");
    if (blobKeys == null) {
        return null;
    } else {
        for(BlobKey blobKey : blobKeys){
            // ImagesService services = ImagesServiceFactory.getImagesService();
            // ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);
            // String imageUrl = services.getServingUrl(serve);
            BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
            BlobInfo info = blobInfoFactory.loadBlobInfo(blobKey);
            System.out.println("Image URL : "+imageUrl);
            System.out.println("Image FileName : "+info.getFilename());
        }
    }
}