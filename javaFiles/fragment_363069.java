@Parameters
public static Collection<Object[]> readPropertiesFile(){
    ArrayList<Object[]> result= new ArrayList<Object[]>();
    try {
        Configuration config = new PropertiesConfiguration("testPaths.properties");
        Iterator<String> keys=config.getKeys();
        while(keys.hasNext()){
            String[] paths= config.getStringArray(keys.next());
            result.add(paths);          
        }
    } catch (ConfigurationException e) {
        e.printStackTrace();
    }
    return result;
}