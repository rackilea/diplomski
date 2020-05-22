class MyClass {}

class MyComparator implements Comparator {
    int compareTo(Object o1, Object o2){
      ...
    }
}
final Set set = new TreeSet(new MyComparator());
set.add(new MyClass());
....
set.add(new MyClass());