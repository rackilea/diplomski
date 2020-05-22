public class MyClass implements Comparable<MyClass>{
    public int x;

    public int compareTo(MyClass mc){
        return x - mc.x;
    }
}