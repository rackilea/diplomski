public class OuterClass{
    private Object variable = "variable";

    private class InnerClass{
        private void method(){
            //This line compiles:
            System.out.println("variable = "+variable);

            //So does this one - both lines refer to the same 
            //enclosing instance of OuterClass:
            System.out.println("variable = "+OuterClass.this.variable);
        }
    }
}