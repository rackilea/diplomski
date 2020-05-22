private void checkString(String st, boolean or) {
    if (st.length() <= 0 || or){
        JOptionPane.showMessageDialog(null, "That is not a valid input.","Input error",JOptionPane.ERROR_MESSAGE);
        addRecord();
    }
}
private void addRecord() {
    String firstName = JOptionPane.showInputDialog("First Name: ");
    checkString(firstName, false);

    String lastName = JOptionPane.showInputDialog("Last Name: ");
    checkString(lastName, false);

    String a = JOptionPane.showInputDialog("Student Number: ");
    int studentNumber = Integer.parseInt(a);
    checkString(a, studentNumber == 0);

    String major = JOptionPane.showInputDialog("Major: ");
    checkString(major, false);

    String b = JOptionPane.showInputDialog("GPA: ");
    double gpa = Double.parseDouble(b);
    checkString(b, gpa > 4.0);

    tree.addNode(studentNumber, firstName, lastName, major, gpa);
}