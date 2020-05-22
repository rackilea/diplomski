class MyClass {
     // Note that this method doesn't really add any benefit to
     // simply using String.split().
     public static String[] xxxx(String entry){
        String[] parts=entry.split(" ");
        return parts;
     }
}

class OtherClass {
    public void someMethod(String str) {
        String[] p = MyClass.xxxx(str);
        System.out.println(p[0]);
        System.out.println(p[1]);
    }
}