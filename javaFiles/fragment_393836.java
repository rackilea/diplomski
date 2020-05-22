btn_next.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        counter = counter++ % songurl.length
        textview.setText(songurl[counter]);
        try {
            mediaPlayer.reset();
        } catch (Exception ex) {
            try {
                mediaPlayer.setDataSource(songurl[counter]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
        }

    }
});