public class YourAbstractFactory {

    private static Map<String, Class> classez = new HashMap<String, Class>();

    public static YourAbstract initFactory(Map<String, Class> classes) {
        // initialize your map
        classez.putAll(classes);
    }

    public static YourAbstract initFactory(Collection<String> classes) {
        // initialize your map
        for(String className : classes) {
            try {
               Class c = Class.forName(className);
               classez.put(className, c);
            } catch (Exception e) {
               // handle the way you need it ... e.g.: e.printStackTrace();
            }
        }
    }

    public static YourAbstract createObject(String className) {
        try {
           Class c = classez.get(className);
           YourAbstract newObject = (YourAbstract)c.newInstance();
           return newObject;
        } catch (Exception e) {
           // handle the way you need it ... e.g.: e.printStackTrace();
        }
    }
}