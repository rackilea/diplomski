btnStartStop.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {

    if(!longPress){
        //Do stuff
    }
    else{
        Toast.makeText(getApplicationContext(), "Button is locked!\nLong press button to unlock it",Toast.LENGTH_SHORT).show();
    }
});