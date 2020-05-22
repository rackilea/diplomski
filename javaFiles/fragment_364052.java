File newFile = new File ("C:/Documents and Settings/Admin/Desktop/Keys.txt");

if (newFile.exist()) {
    System.out.print("File is existing");
}

BufferedWriter write = new BufferedWriter (new FileWriter (newFile));
BufferedReader read = new BufferedReader (new FileReader (newFile));