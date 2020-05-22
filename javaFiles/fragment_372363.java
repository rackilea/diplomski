private static final String PERSON_QUERY;

static{
    InputStream str = null;
    try{
        str = ThisClass.class.getResourceAsStream("/path/to/query.sql");
        PERSON_QUERY = IOUtils.toString(str);
    }catch(IOException e){
        throw new IllegalStateException("Failed to read SQL query", e);
    }finally{
        IOUtils.closeQuitely(str);
    }

}