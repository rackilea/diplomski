class ButtonEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if ((!name.getText().equals("")) && (!course.getText().equals(""))
                && (n < S.length)) {
            S[n++] = new Student(name.getText(), Integer.parseInt(course
                    .getText()), check.isSelected());
            String message = "Student #" + n
                    + " has been successfully added to database!";
            JOptionPane.showMessageDialog(null, message, "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }

        name.setText("");
        course.setText("");
        check.setSelected(false);

        if (n == S.length) {
            dispose();
            int c = Integer
                    .parseInt(JOptionPane
                            .showInputDialog("Enter the course you want to look through:"));
            int count = 0;
            for (int i = 0; i < S.length; i++) {
                if (S[i].isDolg(c))
                    count++;
            }
            JOptionPane.showMessageDialog(null, "There are " + count
                    + " students lagging behind at " + c + " course!");
        }
    }
}

public static void main(String[] args) {
    int l = Integer.parseInt(JOptionPane
            .showInputDialog("Enter amount of students:"));
    Test app = new Test(l);
    app.setVisible(true);

}