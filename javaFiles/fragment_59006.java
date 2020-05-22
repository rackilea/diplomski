Object[] options = {"Yes, please",
                "No way!"};
int n = JOptionPane.showOptionDialog(frame,
"Would you like green eggs and ham?",
"A Silly Question",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
null,     //do not use a custom Icon
options,  //the titles of buttons
options[0]); //default button title