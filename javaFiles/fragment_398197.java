final String storageConnectionString ="connectionstring";

    CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);

    CloudBlobClient serviceClient = account.createCloudBlobClient();

    CloudBlobContainer container = serviceClient.getContainerReference("test");
    container.createIfNotExists();

    File file = new File("E:\\Test");
    for(ListBlobItem item : container.listBlobs()){
        CloudBlockBlob cloudBlob = (CloudBlockBlob) item;
        File f = new File(file.getAbsolutePath() + "\\" +cloudBlob.getName() );
        cloudBlob.downloadToFile(f.toString());
        System.out.println(cloudBlob.getName()+" success download");
    }