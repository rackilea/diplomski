File file = new File(filename.trim().isEmpty() ? "output.txt" : filename);

try {       
    file.createNewFile();
} catch(IOException ex) {
    //file was not created successfully
}