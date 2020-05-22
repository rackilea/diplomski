public void actionPerformed(ActionEvent b) {
       if (b.getSource() == jrbStudent) {
           m1.addStudent(name.getText(), address.getText(), balance.getText(), major.getText());
           echoStudent.setText("Created Student: \n" + m1.getLastStudent());
       }

       if (jrbGraduate.isSelected()) {
            m1.addGradStudent(name.getText(), address.getText(), balance.getText(), major.getText());
            echoStudent.setText("Created Graduate Student: \n" + m1.getLastGradStudent());
       }
}