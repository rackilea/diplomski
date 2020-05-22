Properties prop = new Properties();
InputStream input = new FileInputStream("condition.properties");

// load a properties file
prop.load(input);

// get the property value and print it out
String value = prop.getProperty("database");

//Condition
if("true".equals(value))
   //Code-A
else
   //Code-B