public class OuterClass{
    private Object variable = "variable";

    private static class StaticNestedClass{
        private OuterClass parent;

        private StaticNestedClass(OuterClass p){ parent = p; }

        private void method(){
            //This line compiles:
            System.out.println("variable = "+parent.variable);

            //This won't - there's no OuterClass enclosing instance:
            //System.out.println("variable = "+OuterClass.this.variable);

            //This one won't either, for the same reason:
            //System.out.println("variable = "+variable);
        }
    }
}