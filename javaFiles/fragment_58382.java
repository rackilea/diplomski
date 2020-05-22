saveButton.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent arg0){
            //writeStudentInfo();
            studentNumber = numberText.getText();
            System.out.print("clickec"+studentNumber);
        }
    });