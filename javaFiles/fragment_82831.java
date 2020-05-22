File file = new File("textfile.txt");
System.out.println("Exists: " + f.exists());
if (!file.exists()) {
    if (!file.createNewFile()) {
        System.out.println("Sorry, could not create " + file);
    } else {
        System.out.println("Create file " + file + " successfully");
    }
}