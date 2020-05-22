try {
    Class.forName("org.netezza.Driver");
} catch (ClassNotFoundException e) {
    String msg = "Driver is missing\n" +
            "install and rerun the application";
    JOptionPane.showMessageDialog(this, msg, this.getTitle(), JOptionPane.ERROR_MESSAGE);
    System.exit(1);
}