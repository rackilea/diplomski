public static void find() {
    File dir = new File(
            "D:\\test\\28-4-2016\\apa\\5346560_1\\ItemFile\\1444799103007_1\\ftp\\content-providers\\apa-e\\data\\incoming\\CBS_v47i4");
    foundFolder = findDirectory(dir);
}

private static boolean findDirectory(File parentDirectory) {
    System.out.println(parentDirectory.getPath());
    File[] files = parentDirectory.listFiles();
    for (File file : files) {
        if (!file.isFile()) {

            if (file.getName().equals("incoming")) {

                System.out.println("Incoming Folder found : ");
                System.out.println("Incoming filder path : " + file.getAbsolutePath());
                System.out.println("Parent path :  " + file.getParent());
                return true;
            } else if (file.isDirectory()) {
                return findDir(file);
            }
        }
    }
    System.out.println("Incoming Folder not found : ");
    return false;
}