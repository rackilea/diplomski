public Properties getProperties() throws IOException
{
    if(properties != null)
        return properties;

    //else, initialize
    properties = new Properties();
    String propFileName = System.getProperty("propertiesfilelocation");
    InputStream inputStream = null;

    inputStream = new FileInputStream(propFileName);

    if (inputStream != null)
        properties.load(inputStream);

    Date date = new Date();
    SimpleDateFormat formatter = 
    new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
    String formattedDate = formatter.format(date);
    properties.put("time", formattedDate);

    return properties;
}