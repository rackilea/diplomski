mButton = (Button) findViewById(R.id.button56) ;
    String phno = object.getString("telephone");

    if(phno==null || phno.equals("")){
        mButton.setClickable(false);
        mButton.setEnabled(false);
    }
else{
        mButton.setEnabled(true);
        mButton.setClickable(true);
}