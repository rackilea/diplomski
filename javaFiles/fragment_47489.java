BlobInfoFactory bif = new BlobInfoFactory();
BlobKey bk = new BlobKey("<your blobkey>");
BlobInfo blobInfo = bif.loadBlobInfo(bk);

if(blobInfo == null)
    // The blob with the provided blobkey does not exists
else
    String contentType = blobInfo.getContentType();