Object[] options = {"Quit, My Computing Fellow", "No, I want to Work more"};

   int Answer = JOptionPane.showOptionDialog(null, "What would you like to do?","Quit:Continue", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
null, options,options[1]);
if(Answer == JOptionPane.YES_OPTION){

    System.exit(0); 
}
else if (Answer == JOptionPane.CANCEL_OPTION) {
    return;
}