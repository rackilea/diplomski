@Override
public String uploadDirectory(JSONObject jsonInput) throws IOException {
    CloudFileClient fileClient = null;
    try {
        fileClient = FileClientProvider.getFileClientReference();
        String directoryLocation = jsonInput.get("directoryLocation").toString();
        File f = new File(directoryLocation);

        CloudFileShare share = 
        fileClient.getShareReference(f.getName().toLowerCase().replace(".", "").replace("_", ""));
        if (share.createIfNotExists()) {
            System.out.println("New share created");
        }
        CloudFileDirectory rootDir = share.getRootDirectoryReference();

        listFilesAndUploadToCloud(f.getAbsolutePath(), rootDir);

    } catch(Exception e) {
        System.out.println("Exception " + e);
    }
    return "Check";
} 

public void listFilesAndUploadToCloud(String filePath, CloudFileDirectory storageDir) throws Exception {

    File f = new File(filePath);
    ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

    for (File file : files) {
        if (file.isFile()) {
            CloudFile cloudFile = storageDir.getFileReference(file.getName());
            cloudFile.uploadFromFile(file.getAbsolutePath());
        } else {
            CloudFileDirectory cloudDir = storageDir.getDirectoryReference(file.getName());
            if (cloudDir.createIfNotExists()) {
                listFilesAndUploadToCloud(file.getAbsolutePath(), cloudDir);
            }
        }
    }

}