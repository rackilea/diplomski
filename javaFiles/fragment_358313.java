void aMethod() {

    class MethodLocalInner {

            void bMethod() {

                    System.out.println("Inside method-local bMethod");
            }
    }

    MethodLocalInner foo = new MethodLocalInner(); // Default Constructor
    foo.bMethod();

}