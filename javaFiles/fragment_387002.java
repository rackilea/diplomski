btnEnter.addActionListener(new ActionListener() {       
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try{
                temp = Double.parseDouble(txtFahr.getText());
                double X = (temp - 32)* 0.69;
                lblResult.setText(String.valueOf(X));
                lblError.setText(" ");
                this.repaint();
            }
            catch(NumberFormatException ex){
                lblError.setText("Invalid Celsius Value");
            }
        }
    });