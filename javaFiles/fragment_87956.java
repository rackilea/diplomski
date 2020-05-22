public class PalindromeTask08 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int count = 5;
        int x =0;

        //loops to input a word 
        do {
            System.out.println("input a word");
            String answer = in.next();
            if (answer.equals(new StringBuilder(answer).reverse().toString())) {
                System.out.printf("%s is a palindrome", answer);
            } else {
                System.out.printf("%s is NOT a palindrome", answer);
            }
            --count;
            System.out.println("\n you have %d more attempts "+ count);
        } while(count!=0);
        in.close();
    }
}