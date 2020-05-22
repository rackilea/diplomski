btnDel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < newCourse.Students.size(); i++) {
                if (newCourse.Students.get(i).getFirstName().equals(studentsBox.getSelectedItem()
                        .toString())) {
                    newCourse.Students.remove(i);
                    JOptionPane.showMessageDialog(null, "Student Deleted");
                    studentsBox.removeAllItems();
                    for (int t = 0; t < newCourse.Students.size(); t++) {
                        String p = newCourse.Students.get(t).getFirstName();
                        studentsBox.addItem(p);
                    }
                }
            }
        }
    });