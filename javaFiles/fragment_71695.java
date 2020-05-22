File file = new File("myfil"); 
String fileContent = ""; // String to keep track of file content
try { 
    FileInputStream fis = new FileInputStream(file);
    int content; 

    while ((content = fis.read()) != -1) 
    {
        fileContent += (char)content; // append this to the file content as char
    }
} catch (IOException e) {
    System.out.print("Problem reading file");
}

System.out.print(fileContent); // print it