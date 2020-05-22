properties.setProperty(username, decryptMD5(password));
try{
    //get the filename from url class
    URL url = ClassLoader.getSystemResource("user.properties");
    String fileName = url.getFile();

    //write to the file
    props.store(new FileWriter(fileName),null);
    properties.store();
}catch(Exception e){
    e.printStacktrace();
}