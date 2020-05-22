Properties prop = new Properties();
InputStream input = null;
try {
input = new FileInputStream("config.properties");
prop.load(input);
}catch(IOException e){
    //handle exception
}