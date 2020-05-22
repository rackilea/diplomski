try {

    //Use Any Environmental Variable , here i have used CATALINA_HOME
    String propertyHome = System.getenv("CATALINA_HOME");           
    if(null == propertyHome){

        //This is a system property that is  passed
        // using the -D option in the Tomcat startup script
        propertyHome  =  System.getProperty("PROPERTY_HOME");
    }


    String filePath= propertyHome+"/properties/myapp.properties";

    Properties property = new Properties();         
    property.load(SystemTest.class.getClassLoader().getResourceAsStream(filePath));
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}