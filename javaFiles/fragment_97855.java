public void parse() {
    try {
        double d = Double.parseDouble(JOptionPane.showInputDialog("What is the radius of the circle?"));
    } catch (NumberFormatException nfe) {
        //do something with the input here
        nfe.printStacktrace();
    }
}