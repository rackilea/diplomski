class Test {
public static void main(String[] args) {

    String sourceString = "PREFIX <li>Some text\n</li> SUFFIX";
    String regularExpression = "<li>Some text(\n|\r|\r\n)</li>";

    System.out.println("Source string: " + sourceString);
    System.out.println("Regular expression: " + regularExpression);

    System.out.println("Eval result: " + sourceString.replaceAll(regularExpression, ""));
}