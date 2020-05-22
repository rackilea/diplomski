public class StringReverser {
              public static void main(String args[]) {
                System.out.println("Please enter some text to reverse.");
                Scanner scan = new Scanner(System.in);
                String userInput = scan.nextLine();
                displayData(reverse(userInput));
              }

              public static String reverse(String userInput) {
                int i = 0;
                while (userInput.length() <= 0) {
                  return userInput;
                }
                String reversed = reverse(userInput.substring(1)) + userInput.charAt(0);
                return reversed;
              }

              public static void displayData(String reversed) {
                System.out.println(reversed);
              }
            }