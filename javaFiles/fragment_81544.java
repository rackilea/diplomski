private final Runnable hideSeekBarRunnable = new Runnable() {
    @Override
    public void run() {
        seekBar.setVisibility(View.INVISIBLE);
    }
};