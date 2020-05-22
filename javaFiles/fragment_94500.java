public class LargestPalindromeProduct {

private static int largestPalindrome() {
    int max = 0;
    for(int i = 100; i<=999; i++) {
            for(int k = 100; k<=999; k++) {
                int product = i*k;
                if (product <= max) {
                    continue;
                }
                String palindrome  = Integer.toString(product);
                boolean good = true;
                for(int j = 0; j<= palindrome.length()-1; j++) {
                    if(palindrome.charAt(j) != palindrome.charAt(palindrome.length() - 1 - j)) {
                        good = false;
                        break;
                    }
                }
                if (good)
                    max = product;
            }
        }
    }
    return max;
}
public static void main(String[] args) {
    int largestPalindrome = largestPalindrome();
    System.out.println(largestPalindrome);
}