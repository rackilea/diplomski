class addaction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            double number=Double.parseDouble(text.getText());
            double result=number*number;
            label1=new JLabel("Your result is"+result);
        }
    }