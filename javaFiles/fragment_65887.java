protected void onResume(){
    super.onResume();


    int numLines = 100;
    int numOfBottles = 99;
    String line;
    String lyrics= "Lyrics to 99 bottles of beer \n\n";

    TextView textview = (TextView) findViewById(R.id.myTextView);

    textview.setText(lyrics);

    for(int i = numOfBottles;i >= 1;i--) {
        if (numOfBottles >= 1) {
            line = "Line " + numLines-i + ":\n";
            textview.append(line + i + " bottles of beer on the wall," + 
                             i + " bottles of beer, take one down, pass it around," + 
                             i-1 + " bottles of beer on the wall.\n\n");
        }
    }
}