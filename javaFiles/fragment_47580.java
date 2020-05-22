EditText edit_text_out_r3ET = (EditText)findViewById(R.id.edit_text_out_r3);

String currentString= edit_text_out_r3ET.getText().toString();

    int wantedStringLength=8;
    int difference;

    difference = wantedStringLength - currentString.length();

        for ( int i=0; i<difference; i++) {
          currentString=” “+currentString;
        }