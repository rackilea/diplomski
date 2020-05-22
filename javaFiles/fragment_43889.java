private void checkOperators(){ 

     //change the id with the id of your EditText
    EditText myEditText = findViewById(R.id.idEditText);

    //Get the last char
    String lastChar = myEditText.getText().toString().substring(myEditText.length());

    if (lastChar.equals("+") || lastChar.equals("*") || lastChar.equals("-") || lastChar.equals("/")){

        //Delete the first operator if they exist
        myEditText.setText(myEditText.getText().toString().substring(0,myEditText.length()-1);
    }


    // replace "newOperator" with your operator
    myEditText.setText(myEditText.getText().append(newOperator);

}