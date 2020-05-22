String value = JOptionPane.showInputDialog("What is your name?");
if (value != null) {
    System.out.println("Hello " + value);
} else {
    System.out.println("Hello no name");
}