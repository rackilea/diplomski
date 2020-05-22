int i = 0;
  for (char myChar = 'A'; myChar <= 'Z'; myChar++) {
     final String btnText = String.valueOf(myChar);
     letter[i] = new JButton(btnText);

     keyboard.add(letter[i]);
     letter[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           textArea.append(btnText);
        }
     });
     i++;
  }