Map<String, List<FileInfo>> infos = blobstoreService.getFileInfos(request);
Long fileSize = infos.get("myFile").get(0).getSize();
Map<String, List<BlobKey>> blobKeys = blobstoreService.getUploads(request);
byte[] fileBytes = 
        blobstoreService.fetchData(blobKeys.get("myFile").get(0), 0, fileSize);
String input = new String(fileBytes);