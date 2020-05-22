public class MainClass {
    private String string="Abcd";

    public static void main(String... arr) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException{
        MainClass mainClass=new MainClass();
        Field stringField=MainClass.class.getDeclaredField("string");
        stringField.setAccessible(true);//making field accessible 
        /*if SecurityManager enable then,  
        java.security.AccessControlException: access denied will be thrown here*/
        stringField.set(mainClass, "Defgh");//seting value to field as it's now accessible
        System.out.println("value of string ="+stringField.get(mainClass));//getting value from field then printing it on console
    }
}