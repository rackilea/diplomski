FileService fileService = FileServiceFactory.getFileService();
    AppEngineFile writableFile = fileService.createNewBlobFile(request.getParameter("qqfile"));
    FileWriteChannel writeChannel = null;
        try {
                byte[] buffer = new byte[4096]; // 4MB
                lock = true;
                writeChannel = fileService.openWriteChannel(writableFile, lock);
                // increase the buffer size as you are reading from the 
                // input stream. Read the input stream into buffer
                for (int n; (n = stream.read(buffer)) != -1; ){ 
                    writeChannel.write(ByteBuffer.wrap(buffer));
                } 
            } finally {
                    writeChannel.closeFinally();
            }

    BlobKey blobKey = fileService.getBlobKey(writableFile);
    ImagesService imagesService = ImagesServiceFactory.getImagesService();

    // produces something like http://localhost:8888/_ah/img/SU52WMsoCRP3kqAvQqVW3g
    String imageUrl = imagesService.getServingUrl(blobKey);