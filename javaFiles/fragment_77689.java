try {
    path.getFileSystem().provider().checkAccess(path, AccessMode.EXECUTE);
    System.out.println("can execute "+path);
} catch(IOException ex) {
    System.out.println("can not execute: "+ex);
}