class MyClass implements Comparable { 
  int compareTo(){...}
}
final Set set = new TreeSet();
set.add(new MyClass());
....
set.add(new MyClass());