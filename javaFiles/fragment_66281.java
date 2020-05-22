import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Test {
  public static void main (String[] args) throws IOException {
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    int data = inputStreamReader.read();
    Stack<Character> stack = new Stack<>();
    while (data != -1) {
      char c = (char)data;
      if (Character.isDigit(c)) {
        stack.push(c);
      } else {
        // do whatever you want.
      }
      data = inputStreamReader.read();
    }
  }
}