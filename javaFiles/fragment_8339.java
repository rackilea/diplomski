Reader reader = new FileReader("/my/file/location");
try {
    //Read the file and do stuff
} catch(IOException e) {
    e.printStackTrace();
} finally {
    reader.close();
}