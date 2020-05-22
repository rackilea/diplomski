import java.io.StringReader;

public class Re {
public static void main (String[] args) {
String name = "(My name is Bob)(I like computers)";

StringReader s = new StringReader(name);

try {
    // This is the for loop that I don't know
    String result = "";
    int c = s.read();
    for (;c!= ')';) {
        result = result + (char)c;
        // Here the char has to be appended to the String result.
        c = s.read();
    }
    result = result + ')';
    System.out.println("The string is: " + result);

} catch (Exception e) {
    e.toString();
}

}
}