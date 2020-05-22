class startTextFieldListener implements ActionListener {
     String correctAnswer;
     startTextFieldListener(String answer)
     {
         correctAnswer = answer;
     }

         @Override
        public void actionPerformed(ActionEvent event) {
             if (text.getText().equals(correctAnswer)) {
                JOptionPane.showMessageDialog(null, "Hooray!");
             }

             else {
                JOptionPane.showMessageDialog(null, "Wrong!");
             }

          }
     }
    }