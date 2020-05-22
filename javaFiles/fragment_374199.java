Properties properties = new Properties();
ClassLoader classloader = Thread.currentThread()
                    .getContextClassLoader();
            is = classloader.getResourceAsStream(location);//location:your path of the properties file
            properties.load(is);

            properties.getProperty("Your Key");