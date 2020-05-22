public class MyClass implements Comparable<MyClass> {
     int x;
      ...
      @Override
        public int compareTo(MyClass o) {
            return o.x-x;
        }
    public static void main(String args[]) {
       MyClass[] myarray=new MyClass[10];
       ...
       Arrays.sort(myarray);
    }
}