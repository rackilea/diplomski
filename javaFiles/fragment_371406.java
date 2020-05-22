package de.scrum_master.app;

@MyAnnotation(id = 1, name = "class")
public class Application {
    @MyAnnotation(id = 2, name = "member")
    private String member = "foo";

    @MyAnnotation(id = 3, name = "method")
    public static void main(String[] args) {
        new Application().doSomething("blah", Math.PI);
    }

    private String doSomething(String text, @MyAnnotation(id = 4, name = "parameter") double number) {
        String returnValue = member + " " + number;
        member = text;
        return returnValue;
    }
}