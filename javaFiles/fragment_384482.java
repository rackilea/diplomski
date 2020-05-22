String[] labels = {
        "Found better price",
        "Not as shown on website",
        "Wrong product",
        "Damaged upon delivery",
        "None of the above"
};
JList<String> list = new JList<>(labels);
int option = JOptionPane.showConfirmDialog(null, list, 
        "Please tell us why you wish to return your purchase.", 
        JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
    String selectedValue = list.getSelectedValue();
    System.out.println(selectedValue); // Do something with it.
}