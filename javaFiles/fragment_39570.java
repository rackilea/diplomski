public class NullFieldSSCCE {

    static abstract class Parent {
        List<String> values = new ArrayList<String>() {{
          System.out.println("Parent.values instantiation");  
        }};

        Parent() {
            System.out.println("Parent()");
            values.addAll(getValues());
        }

        protected abstract List<String> getValues();   
    }

    static class Child extends Parent {

        String param1="test1";
        String param2="test2";
        Object param3 = new Object() {{System.out.println("Child.param3 instantiation"); }};

        Child() {
            System.out.println("Child()");
        }

        @Override
        protected List<String> getValues() {
            System.out.println("Child.getValues()");
            return Arrays.asList( new String[] {param1, param2} );
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        Child child = new Child();

        System.out.println("Child p1="+child.values.get(0)+", p2="+child.values.get(1));
    }

}