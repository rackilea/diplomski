public static double getMeters() {
    String str;
    double meters;

    // Get meters input from user:
    str = JOptionPane.showInputDialog("Enter a distance in meters: ");

    // Convert string input to double:
    meters = Double.parseDouble(str);

    // Validate input:
    if (meters <= 0) {
        JOptionPane.showMessageDialog(null, "Error: Input must be a " +
                " positive number");
        return getMeters();
    } else
        return meters;
}