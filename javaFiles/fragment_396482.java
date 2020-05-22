Properties appProperties = new Properties();
FileInputStream file;

String path = "./some_properties_file.properties";    
file = new FileInputStream(path);

appProperties .load(file);
String propValue= appProperties .getProperty("Property_Name");