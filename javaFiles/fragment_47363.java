public class A {

    public void method() throws IOException {

        //code is written here.
        String attributeName = lAttribute.getName(); 
    } 

    public void anotherMethod() {
        try {
            method();
        } catch(IOException ex) {
            ...
        } 
    }
}