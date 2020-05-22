String input = JOptionPane.showInputDialog("\nPlease enter the number you wish to obtain the factorial for");
number = -1;
try {
    number = Integer.parseInt(input);
} catch (NumberFormatException nfe) {
    ... // Show a message here saying that "input" is invalid
}