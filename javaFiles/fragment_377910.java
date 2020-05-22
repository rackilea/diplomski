public Integer promptForInt(String prompt) {
    Integer value = null;
    boolean exit = false;

    do {
        String input = JOptionPane.showInputDialog(prompt);
        if (input != null) {
            try {
                value = Integer.parseInt(input);
            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "Input must be a number.");
            }
        } else {
            exit = true;
        }
    } while (value == null && !exit);

    return value;
}