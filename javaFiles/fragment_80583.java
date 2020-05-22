//Create new File
File file = new File("C:/test/testFile.exe");

//Check if file exists
if (file.exists()) {
    System.out.println("The File Exists");

    //Check if file is executable
    if (file.canExecute()) {
        System.out.println("The File is executable");
    }
}