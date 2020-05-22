public void printLevel(File file) {
    if (!file.isDirectory()) {
        System.out.println(file.getName() + "--FILE");
        return;
    }

    System.out.println(file.getName() + "*****DIRECTORY*****");
    File[] subs = file.listFiles();
    for (File sub : subs) {
        printLevel(sub);
    }
}