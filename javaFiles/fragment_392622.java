boolean valid = false;
while (!valid) {
    int time;
    try {
        time = Integer.parseInt(JOptionPane.showInputDialog("Enter seconds"));
        if (time >= 0) valid = true;
    } catch (NumberFormatException e) {
        //error
        JOptionPane.showConfirmDialog("Error, not a number. Please try again.");
    }
}