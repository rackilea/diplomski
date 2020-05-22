static Properties databaseproperties= new Properties();
    static {
        try {
            connectionProps.load(YourClassName.class.getClassLoader()
                    .getResourceAsStream("databaseproperties.properties"));
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }