public class MyClass{
    public int x;
}

public class MyClassComparator implements Comparator<MyClass>{
    public int compare(MyClass mc1, MyClass mc2){
        return mc1.x - mc2.x;
    }
}