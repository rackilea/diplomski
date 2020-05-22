public class Example {
  public static void iterateAndDoSomething(Iterator<MyClass> iter) {
    while(iter.hasNext()) {
        MyClass mc = iter.next();
        /* code without modification to list */
        /* code with modification to list */
    }
  }

  public static void main(String[] args) {
    ArrayList<MyClass> als = new ArrayList<MyClass>();
    TreeSet<MyClass> tss = new TreeSet<MyClass>();
    iterateAndDoSomething(als.iterator());
    iterateAndDoSomething(tss.iterator());
  }
}