public double getGP(JTextField a) {
    // Don't forget, this needs to be txt12 (not txt11).
    String str = a.getText();
    str = (str != null) ? str.trim().toUpperCase() : "";
    if (str.equals("A")) {
        return 4.0;
    } else if (str.equals("B+")) {
        return 3.5;
    } else if (str.equals("B")) {
        return 3.0;
    } else if (str.equals("C+")) {
        return 2.5;
    } else if (str.equals("C")) {
        return 2.0;
    } else if (str.equals("D")) {
        return 1.0;
    }
    return 0.0;
}