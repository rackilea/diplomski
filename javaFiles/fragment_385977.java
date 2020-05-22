public static void main(String[] args) {
    String myVar1 = null;
    String myVar2 = null;
    Properties prop = new Properties();
    InputStream input = null;
    try (FileInputStream input = new FileInputStream("pathToYourFile")) {
        prop.load(input);

        myVar1 = prop.getProperty("Directory_path");
        myVar2 = prop.getProperty("school_name");

    } catch (IOException ex) {
        //Handle exception
    } 
}