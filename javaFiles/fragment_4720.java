Map<String, List<BlobInfo>> blobsData = blobstoreService.getBlobInfos(request);
for (String key : blobsData.keySet())
    {
        for(BlobInfo blob:blobsData.get(key))
        {
            byte[] b = new byte[(int)blob.getSize()];
            BlobstoreInputStream in = new BlobstoreInputStream(blob.getBlobKey());
            in.read(b);

            GcsService gcsService = GcsServiceFactory.createGcsService();
            GcsFilename filename = new GcsFilename(BUCKETNAME, "/testFolder3/"+blob.getFilename());
            GcsFileOptions options = new GcsFileOptions.Builder()
            .mimeType(blob.getContentType())
            .acl("authenticated-read")
            .addUserMetadata("myfield1", "my field value")
            .build();

            gcsService.createOrReplace(filename, options,ByteBuffer.wrap(b));
            in.close();
        }
    }