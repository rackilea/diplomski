int time;
try {
    time = Integer.parseInt(JOptionPane.showInputDialog("Enter seconds"));
} catch (NumberFormatException e) {
    //error
}