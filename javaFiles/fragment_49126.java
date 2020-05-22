public void onClick(View v) {
    String ButtonText=one.getText().toString();
    // method call that plays the sound
    if(ButtonText.equals("Stop")){
        one.setText("Play");
    } else {
        one.setText("Stop");
    }
}