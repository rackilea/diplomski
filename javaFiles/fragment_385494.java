File fdelete = new File(uri.getPath());
if (fdelete.exists()) {
    if (fdelete.delete()) {
        System.out.println("file Deleted :" + uri.getPath());
    } else {
        System.out.println("file not Deleted :" + uri.getPath());
    }
}