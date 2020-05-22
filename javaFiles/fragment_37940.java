youredittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
          MediaPlayer mp = MediaPlayer.create(this, R.raw.yourmp3); // add mp3 file 
          mp.start();
            }
        });