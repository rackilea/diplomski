String path = "C:\\random\\number\\of\\folders\\dataset\\main_folder_name\\folder1\\folder2\\folder3\\myfile.xml";
File search = new File(path);
File lastParent = search;
while (search != null) {
    if ("dataset".equals(search.getName())) {
        break;
    }
    lastParent = search;
    search = search.getParentFile();
}
if (lastParent != null) {
    System.out.println(lastParent.getCanonicalPath());
}