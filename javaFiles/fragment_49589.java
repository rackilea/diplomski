import java.util.Scanner;
import java.util.Stack;

// use Capital letters in the beginning of class names
public class BracketCheck {
    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        Scanner input = new Scanner(System.in);
        String buff;

        System.out.println("please enter brackets & text");
        buff = input.nextLine();
        input.close();
        // using java8 makes iterating over the characters of a string easier
        buff.chars().forEach(current -> {
            // if <current> is an opening bracket, push it to stack
            if (current == '(' || current == '{' || current == '[') {
                stack.push((char) current);
            }
            // if <current> is a closing bracket, make sure it is matching an opening
            // bracket or alert and return
            else if (current == ')' || current == '}' || current == ']') {
                if (!match(stack, (char) current)) {
                    System.out.println("no good");
                    return;
                }
            }
        });
        // if, after we finished iterating the string, stack is empty, all opening
        // brackets had matching closing brackets
        if (stack.isEmpty()) {
            System.out.println("bout time......");
        }
        // otherwise, alert
        else {
            System.out.println("woah");
        }
    }

    private static boolean match(Stack<Character> stack, Character closer) {
        // if stack is empty, the closer has no matching opener
        if (stack.isEmpty()) {
            return false;
        } else {
            // get the most recent opener and verify it matches the closer
            Character opener = stack.pop();
            if (opener == '(' && closer == ')')
                return true;
            else if (opener == '[' && closer == ']')
                return true;
            else if (opener == '{' && closer == '}')
                return true;
            else
                return false;
        }
    }
}