public enum Answer {

    BLUE('b',"Blue"), RED('r',"Red"),
    GREEN('g',"Green"), YELLOW('y',"Yellow");

    private static final String[] prefix = new String[] {"Zero", "One"};

    char letter;
    String name;

    Answer(char letter, String name) {
        this.letter = letter;
        this.name = name;
    }

    public static String getForInput(char input, int index) {

        if (index > prefix.length)
            return "value out of range " + index;

        for (Answer answer : Answer.values()) {
            if (input == answer.letter)
                return prefix[index] + " " + answer.name;
        }
        return "unable to find answer for input " + input;
    }
}

public static String getAnswer() {

    System.out.println("Enter your input: ");
    Scanner reader = new Scanner(System.in);
    String input = reader.nextLine().toLowerCase();
    int number = Integer.valueOf(input.substring(0, 1));
    char letter = input.substring(1).charAt(0);

    return Answer.getForInput(letter, number);

}