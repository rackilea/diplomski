public class Main {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Please type some words, then press enter: ");

    String words = sc.nextLine();

    int count = 0;
    double sum = 0;
    double average = 0;

    sc = new Scanner(words);

    while (sc.hasNext()) {

        String userInput = sc.next();

        double charNum = userInput.length();
        sum = charNum + sum;
        count++;

        if (count > 0) {
            average = sum / count;
        }
    }
    System.out.println("Average word length = " + average);
}