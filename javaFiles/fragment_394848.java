public class Cloner {
    public static abstract class Person {
       protected abstract Object clone1() throws CloneNotSupportedException;
       public Object copy() throws CloneNotSupportedException {
           return clone1();
       }
    }
    public static class Employee extends Person implements Cloneable {
        @Override
        protected Object clone1() throws CloneNotSupportedException {
            return super.clone();
        }

    }
    public static void main(String[] args) throws Exception {
        new Employee().copy();
    }
}