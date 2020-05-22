if( tombolbaca.getText().toString().equals("Baca 10x"){ // this line says "if the text is exactly Baca 10x, go on"
        klik10--; // this line says: "make the value of klik10 = klik10 -1
        tombolbaca.setText("Baca " + klik10 + "x"); //this line says "set text of tombolbaca as the composition of the strings and the value of klik10

        if (klik10 <= 0) //if klik10 is equal or less than 0, do this
        {
            mTitle.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
        }