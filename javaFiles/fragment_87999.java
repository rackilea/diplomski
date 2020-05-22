@Override
public void map(Key key, Entity value, Context context) {
    log.info("Mapping key: " + key);

    try {

        Entity picture = value;

        if (!picture.hasProperty("blobKey") || picture.getProperty("blobKey") == null) {
            String fileName = (String) picture.getProperty("fileName");
            String contentType = (String) picture.getProperty("contentType");       
            Blob image = (Blob) picture.getProperty("image");       

            if (contentType != null && image != null) {

                AppEngineFile file = fileService.createNewBlobFile(contentType,fileName);         
                FileWriteChannel writeChannel = fileService.openWriteChannel(file, true);         
                writeChannel.write(ByteBuffer.wrap(image.getBytes()));
                writeChannel.closeFinally();

                BlobKey blobKey = fileService.getBlobKey(file);     

                picture.setProperty("blobKey",blobKey);
                datastore.put(picture);
            }
            else {
                log.log(Level.SEVERE, "Mapping key: " + key + "failed - null contentType or image.");
            }

        }
    } catch (Exception e) {
        log.log(Level.SEVERE, "Mapping key: " + key, e);

    }


}