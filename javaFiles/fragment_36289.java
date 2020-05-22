// Change constructor
public RandomNumGame() {
    ...
    guessed = true; // initialize to true to create a new number when you click
}
private class Event implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if(guessed) { // If the number was guessed, on the next click you get a new random number
            randomNum = (int )(Math.random() * 1000 + 1);
            guessed = false;
        }
        try{
            guessNum = (int)(Double.parseDouble(txt.getText()));
            if(guessNum>randomNum){
               resultLabel.setText("Your number is higher. Try Again");
            }
            else if(guessNum<randomNum){
               resultLabel.setText("Your number is lower. Try Again");
            }
            else{
               resultLabel.setText("Your number matched! Click again for a new Number");
               guessed=true;
            }
        }
        catch(Exception ee){
            resultLabel.setText("Enter a legit number. What are you stupid?");
        }
    }
}