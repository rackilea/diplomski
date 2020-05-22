public class MyComparator implements Comparator<MyClass>{
    @Override
    public int compare(MyClass o1, MyClass o2) {
        // Your comparison logic
    }
} 
...
Collections.sort(list, new MyComparator());