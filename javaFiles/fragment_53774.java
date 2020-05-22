public static String getValue(SomeClass obj1) {
    String s = "";
    try {
       s =  obj1.getObj2().getObj3().getObj4().toString();
    }
    catch (NullPointerException ex) {
        // set s to something else if you want to.
    }
    return s;
}