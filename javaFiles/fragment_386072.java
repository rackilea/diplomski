JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (checkDuplicate(enterStudentTxt)){ 
                    UIStudentInfo studentInfoScreen = new UIStudentInfo();
                    studentInfoScreen.setVisible(true);
                }
            }

        });