@Override
public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
  switch(seekbar.getId()) {
    case R.id.simpleSeekBar1:
        // code block for first Seek bar 
        break;
    case R.id.simpleSeekBar2:
        // code block for second Seek bar 
        break;
    }
}


SeekBar simpleSeekBar = (SeekBar) findViewById(R.id.simpleSeekBar1); // initiate the first Seek bar 
SeekBar simpleSeekBar = (SeekBar) findViewById(R.id.simpleSeekBar2); // initiate the second Seek bar