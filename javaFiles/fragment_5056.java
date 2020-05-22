Properties props = new Properties();
    try {
        InputStream inStream = **YOUR_CLASS_NAME**.class.getResourceAsStream("/log4j.properties");
        props.load(inStream);
    } catch (Exception e){
        LOG.error(e);
    }
    PropertyConfigurator.configure(props);