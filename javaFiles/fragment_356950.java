public void getUploaded(@PathVariable String key, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
        try {
            BlobKey blobKey = new BlobKey(key);
            BlobInfo blobInfo =  new BlobInfoFactory().loadBlobInfo(blobKey);
            OutputStream output = res.getOutputStream();

            InputStream is = new ByteArrayInputStream(readData(blobKey,blobInfo.getSize()));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0)
                output.write(buffer, 0, length);
            is.close();
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] readData(BlobKey blobKey, long blobSize) {
        BlobstoreService blobStoreService = BlobstoreServiceFactory
                .getBlobstoreService();
        byte[] allTheBytes = new byte[0];
        long amountLeftToRead = blobSize;
        long startIndex = 0;
        while (amountLeftToRead > 0) {
            long amountToReadNow = Math.min(
                    BlobstoreService.MAX_BLOB_FETCH_SIZE - 1, amountLeftToRead);

            byte[] chunkOfBytes = blobStoreService.fetchData(blobKey,
                    startIndex, startIndex + amountToReadNow - 1);

            allTheBytes = ArrayUtils.addAll(allTheBytes, chunkOfBytes);

            amountLeftToRead -= amountToReadNow;
            startIndex += amountToReadNow;
        }

        return allTheBytes;
    }