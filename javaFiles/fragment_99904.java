public static void addTo(String s){
    s += " world";
}
public static void addTo(MyStringClass s){
    s.setValue(s.getValue() + " world");
}
public static void main(String[] args){
    String s = "hello";
    MyStringClass s1 = new MyStringClass("hello");
    addTo(s);
    addTo(s1);
    System.out.println(s);//hello
    System.out.println(s1);//hello world
}