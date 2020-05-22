public void buttonClic (View view) {
    ImageView[] images = new ImageView[] {
            findViewById(R.id.imageView1),
            findViewById(R.id.imageView2),
            findViewById(R.id.imageView3),
            findViewById(R.id.imageView4)
    }
    Log.i("info", "OK, pictures have been assigned.");
    EditText number = findViewById(R.id.enterNumber);
    String str = number.getText().toString().trim();
    double val = 0;
    boolean enteredSmth = true;
    try {val = Integer.parseInt(str);}
    catch(NumberFormatException e) {enteredSmth = false;}
    if(enteredSmth) {
        enteredNumber = Integer.parseInt(number.getText().toString());
        Log.i("info", "OK, number entered has been parsed");
        if (enteredNumber<=4 && enteredNumber>=1){
            String desiredPic = "pic" + str;
            Log.i("info", "The user desires to view " + desiredPic + ".");
            for (int i = 0; i < images.length; i++) {
                if (i != enteredNumber - 1)
                    images[i].animate().alpha(0).setDuration(2000);
                else
                    images[i].animate().alpha(1).setDuration(2000);
            }
        }
        else {
            Toast.makeText(this, "I'm no mathematician, but "+enteredNumber+" isn't from 1 to 4...", Toast.LENGTH_LONG).show();}
    }
    else {Toast.makeText(this, "What, are you trying to crash the app?! Enter a NUMBER.", Toast.LENGTH_LONG).show();}
}