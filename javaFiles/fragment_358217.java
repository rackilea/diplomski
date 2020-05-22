Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("myApp.props"));
            if(properties.containsKey("1")){
                String[] propertyValues = properties.getProperty("1").split(","); //gets you a and b
            }
        } catch (IOException e) {
            //handle it
        } finally{
            //handle it
        }