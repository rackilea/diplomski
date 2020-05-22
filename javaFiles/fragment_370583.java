public abstract class SimpleProgressChanged implements SeekBar.OnSeekBarChangeListener {

    public abstract void onProgressChanged(int progress);

    @Override
    public void onProgressChanged(final SeekBar seekBar, final int progress,
        final boolean fromUser) {
        onProgressChanged(progress);
    }

    @Override
    public void onStartTrackingTouch(final SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(final SeekBar seekBar) {}
}