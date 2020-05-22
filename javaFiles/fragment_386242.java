// This function gets an array of Strings representing a file's parent folders
// And returns the most inner parent folder's ID
private String makeParentFolders(String[] parentList) {

    File folder = null;
    String folderId = null;
    for(int i = 0; i < parentList.length; i++) {
        folder = new File();
        folder.setMimeType(getMimeType("folder"));
        folder.setTitle(parentList[i]);
        if (i > 0) {
            folder.setParents(Arrays.asList(new ParentReference().setId(folderId)));
        }
        try {
            folder = this.service.files().insert(folder).execute();
            folderId = folder.getId();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    return folder.getId();
}