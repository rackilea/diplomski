import java.util.Queue;
import java.util.LinkedList;

Queue<String> inputs = new LinkedList<String>();
inputs.push("one");
inputs.push("two");
inputs.push("three");
// etc
// Then to check the user input
for (String match : matches) {
  if (match.equals(inputs.peek())) {
    inputs.pop(); // Removes the element you just matched
    testSound.start();
  }
}