private void onTextSizeSeekBarChange() {
    final TextView tutorialText = (TextView) findViewById(R.id.tutorialText);

    SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(CONTEXT);
    int p = SP.getInt("key", p);
    tutorialText.setTextSize(p);

    final SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
    sb.setMax(20);
    sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            p = progress;
            tutorialText.setTextSize(p);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }


        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

                sb.setProgress(p);
                Editor edit = SP.edit();
                edit.putInt("key", p);
                edit.commit();
        }

    });
    }