public class PropertiesToInterfaceGenerator {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        InputStream inputStream =PropertiesToInterfaceGenerator.class.getClassLoader().getResourceAsStream("xyz.properties");
        if(null != inputStream ){
            properties.load(inputStream);
        }
        generate(properties);
    }


    public static void generate(Properties properties) {
        Enumeration e = properties.propertyNames();
        try {
            FileWriter aWriter = new FileWriter("MyProperties.java", true);
            aWriter.write("public interface MyProperties{\n");
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String val =  properties.getProperty(key);
                aWriter.write("\tpublic static String "+key+" = \""+val+"\";\n");
            }
            aWriter.write(" }\n");
            aWriter.flush();      
            aWriter.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}