import java.util.Scanner;

public class Abcd {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence : ");
        String sentence = sc.nextLine();
        String wordMostVowels = "";
        int maxVowelCount = 0;

        for (String word : sentence.split(" ")) {
            int vowelCount = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                }
            }

            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
                wordMostVowels = word;
            }
        }

        System.out.println("The word with the most vowels (" + maxVowelCount + ") is: " + wordMostVowels);
    }
}