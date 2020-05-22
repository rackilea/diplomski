InputStream is = item.openStream();
try {
   FileService fileService = FileServiceFactory.getFileService();
   AppEngineFile file = fileService.createNewBlobFile(mime, fileName);
   boolean lock = true;
   FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);
   byte[] buffer = new byte[BUFFER_SIZE];
   int readBytes;
   while ((readBytes = is.read(buffer)) != -1) {
       writeChannel.write(ByteBuffer.wrap(buffer, 0, readBytes));
   }
   writeChannel.closeFinally();
   String blobKey = fileService.getBlobKey(file).getKeyString();
} catch (Exception e) {
   e.printStackTrace(resp.getWriter());
}