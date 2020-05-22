CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

CloudFileClient fileClient = storageAccount.createCloudFileClient();

CloudFileShare share = fileClient.getShareReference("test");

CloudFileDirectory rootDir = share.getRootDirectoryReference();

CloudFile file = rootDir.getFileReference("testFile.pdf");

File sourceFile = new File("E:\\AzureFile\\f.pdf");

file.downloadToFile(sourceFile.getAbsolutePath());