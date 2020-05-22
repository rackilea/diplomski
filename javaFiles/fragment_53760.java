public static void main(String[] args) {


    String name = "";
    int direction;
    do {
        int high = (char) 90;
        int low = (char) 66;
        int letter;

        do {
            letter = (high + low) / 2;
            String[] choices = { "Before", "This is the letter", "After",
                    "Done" };

            direction = JOptionPane.showOptionDialog(null,
                    "Is the next letter in your name a(n) \'"
                            + (char) letter
                            + "\' or is it after/before it? ", "Option 2",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, choices, "Option 2");
            System.out.println(direction);
            if (direction == 0)
                high = letter - 1; //

            if (direction == 1 || direction == 3) {
                name += (char) letter;
            }

            if (direction == 2) {
                low = letter + 1; // last guess was too high
            }

        } while (direction != 1 && direction != 3);

    } while (direction != 3);

    JOptionPane.showMessageDialog(null, "Thanks for playing " + name + "!");
}