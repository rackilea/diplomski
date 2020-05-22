String name = JOptionPane.showInputDialog(null,"Enter your name:");
char[] chars = name.toCharArray();
System.out.print("your name is: ");
for (char c : chars) {
    System.out.print((int)c);
    System.out.print(" ");
}