public static void main(String[] args) {
        int digit = 0, letter = 0, punc = 0;
        char c;

        Scanner scanner = new Scanner (System.in);      
        System.out.println("Please enter a sentence below \n\n");
        String sentence = scanner.nextLine();
        scanner.close();

        for (int a = 0; a < sentence.length(); a++) {
            c = sentence.charAt(a);

            if (Character.isLetter(c))
                letter++;

            if (Character.isDigit(c))
                digit++;

            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                punc++;
            }
        }

        System.out.println("Letters: " + letter);
        System.out.println("Numbers: " + digit);
        System.out.println("Punctuation: " + punc);
}