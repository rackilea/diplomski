// Example.java:

package q45326752;

public class Example {
    public static void main(String[] arguments) {
        System.out.println("Hello Checkstyle...");

        int perfectNumber = 1 + 2 + 3;

        System.out.println("Perfect number: " + perfectNumber);
    }
}


Checkstyle warnings:

java -jar checkstyle-8.0-all.jar -c checkstyle-checks.xml Example.java
[ERROR] Example.java:4:29: Parameter arguments should be final. [FinalParameters]
[ERROR] Example.java:7:13: Variable 'perfectNumber' should be declared final. [FinalLocalVariable]