try{
    a = Double.parseDouble(aNumPyt.getText().toString());
}catch (NumberFormatException e){
    //oops, no number available
    a = 0; //default to 0 (or whatever you choose)
}