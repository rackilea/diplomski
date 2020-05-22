for (int i = 0; i < 27; i++) {

     final String buttonText = String.valueOf((char) ('A' + i));
     letter[i] = new JButton(buttonText);

     keyboard.add(letter[i]);
     letter[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           textArea.append(buttonText);
        }
     });

  }