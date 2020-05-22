private static final String DOMAIN;
static{
    InputStream inputStream=null;
    try{
        inputStream = new ClassPathResource("classpath:some.properties")
                          .getInputStream();
        Properties props = new Properties();
        props.load(inputStream);
        String key = "your.property";
        if(!props.containsKey(key))
            throw new IllegalStateException("Property not found");
        DOMAIN= props.getProperty(key);
    } catch(IOException e){
        throw new IllegalStateException(e);
    }finally{
        // apache commons / IO
        IOUtils.closeQuietly(inputStream);
    }
}