public Properties getProperties(String propertiesFileName)
{
    try {
        Properties prop;
        prop = new Properties();
        InputStream in = new FileInputStream(propertiesFileName);
        prop.load(in);
        in.close();
        return prop;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}