String path = servletContext.getRealPath("/MyProps/MyProperty.properties");
        System.out.println("path: " + path);

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(path));
        } catch (Exception e) {
                        e.printStackTrace();
        }
        String name= prop.getProperty("name");