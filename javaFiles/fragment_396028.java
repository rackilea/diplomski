/**
* The code for the button press could be as simple as follows
*/
popBtn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
        try{
            popTextField.setText(popStack);
        }catch(IndexOutOfBoundsException e){
            popTextField.setText("The stack is empty");
        }
    }
});