btnStop.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        soundPool.stop(StreamID);
    }
});