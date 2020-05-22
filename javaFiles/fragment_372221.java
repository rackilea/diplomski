public class MyEvent implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            int guess = 0;

            try {

               guess = Integer.parseInt(input.getText());
                        if(guess>number) {
                            result.setText("Guess Too High. Try Again.");
                            result.setForeground(Color.CYAN);
                        } else if(guess<number) {
                            result.setText("Guess Too Low. Try Again.");
                            result.setForeground(Color.CYAN);
                        } else {
                           result.setText("Right the number was "+number);
                           result.setForeground(Color.GREEN);                      
                        }

            }catch(NumberFormatException nfe){
                result.setText("Error - Illegal Data Entered");
                result.setForeground(Color.RED);               
            }

  }
}