public static void main(String[] args)
{
    int random = 1 + (int)(Math.random() * 5);

    String input = JOptionPane.showInputDialog(null,"Enter a number between 1 and 5: ");
    if(Integer.parseInt(input) == random)
        JOptionPane.showMessageDialog(null, "You guessed correctly!");
    else
        JOptionPane.showMessageDialog(null, "You were " + Math.abs(random - Integer.parseInt(input)) + " away");
    JOptionPane.showMessageDialog(null,"The number is: " + random);
}