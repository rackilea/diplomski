if(seekBar.getId() == R.id.seekBar)
    {
        speed.setText(String.valueOf(progress));
        if(progress<256)
            streams.write((byte)progress);
    }