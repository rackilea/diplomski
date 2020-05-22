public static YourAbstract createObject(String className) {
    try {
       Class c = Class.forName(className);
       YourAbstract newObject = (YourAbstract)c.newInstance();
       return newObject;
    } catch (Exception e) {
       // handle the way you need it ... e.g.: e.printStackTrace();
    }
}