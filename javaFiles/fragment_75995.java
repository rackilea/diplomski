String UserInput = Input.getText().toString();

if(!UserInput.isEmpty()){
    try{
        int number = Integer.parseInt(UserInput);

        Display.setText(UserInput);
    }catch(NumberFormatException e){
        Display.setText("Please enter a number");
    }
}else{
    Display.setText("Please enter a value into the text box");
}