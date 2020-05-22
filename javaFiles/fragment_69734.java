seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int min=1;
            if(progress<min){
                seekBar.setOnSeekBarChangeListener(null);
                seek.setProgress(min);
                seekBar.setOnSeekBarChangeListener(this);
                return;

            }
            Toast.makeText(getApplicationContext(), Integer.toString(progress), Toast.LENGTH_SHORT).show();
            Log.i("test",Integer.toString(progress));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    });