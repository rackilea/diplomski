btnRectangle.addActionListener(new ActionListener() {
       @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource() == btnRectangle){
              TextFieldName.setVisible(false); // set the textfields that you want to be hidden once the Rectangle button is chosen.
           }
        }
 });