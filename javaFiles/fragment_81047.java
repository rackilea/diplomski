@Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            if(seekBar.getId()==R.id.seekBar1){
                seekBar1Progress = (TextView) findViewById(R.id.viewSlider1);
                seekBar1Progress.setText(" " + progress);
            }else if(seekBar.getId()==R.id.seekBar2){
                seekBar2Progress = (TextView) findViewById(R.id.viewSlider2);
                seekBar2Progress.setText(" " + progress);
            }else{
                seekBar3Progress = (TextView) findViewById(R.id.viewSlider3);
                seekBar3Progress.setText(" " + progress);
            }


        }