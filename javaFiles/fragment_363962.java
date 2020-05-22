public class LambdaExample{

    interface Description {
        void describeThis(String str);
    }

    public static void getDescription(Description description, String str){
        description.describeThis(str);
    }

    public static void main(String []args){
        getDescription(new Description() {
            @Override
            public void describeThis(String str) {
                System.out.println(str + " is handsome");  // Meow2x is handsome
            }
        }, "Meow2x");
    }
}