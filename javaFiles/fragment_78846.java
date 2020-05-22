Properties props=new Properties();
InputStream inputStream = 
this.getClass().getClassLoader().getResourceAsStream("example.properties");
props.load(inputStream);
exampleUrl=props.getProperty("baseUrl");
exampleUsername=props.getProperty("username");      
examplepassword=props.getProperty("password");