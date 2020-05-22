class Example {

    public <T> Example(T t) {}

    public static void main(String[] args){

        // In this example the type can be inferred, so new Example("foo") 
        // works, but here is the syntax just to show you the general case.
        Example example = new<String>Example("foo");
    }
}