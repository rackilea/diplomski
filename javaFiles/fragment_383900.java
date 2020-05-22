public class Fizzbuzz {
    public static void main(String[] args) {
         for (int i = 1; i <= 100; i++) {
            String output = "";
            output += (i % 3) == 0 ? "Fizz" : "";
            output += (i % 5) == 0 ? "Buzz" : "";
            System.out.println(output.isEmpty() ? i : output);
        }
    }
}