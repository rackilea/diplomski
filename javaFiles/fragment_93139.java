mLatitudeTextView = (TextView) findViewById((R.id.latitude_textview));
    mLongitudeTextView = (TextView) findViewById((R.id.longitude_textview));

    //share location button
    shareit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String lat = mLatitudeTextView.getText().toString();
            String lng = mLongitudeTextView .getText().toString();
            String finalMsg = "Lat : " + lat + ", Lon : "+ lng;
            intent.putExtra(Intent.EXTRA_TEXT, finalMsg);
            Intent modIntent = Intent.createChooser(intent, "Поделиться..");
            startActivity(modIntent);
        }
    });