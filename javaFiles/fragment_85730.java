public boolean onTouch(View v, MotionEvent event)
{
    if(event.getAction() == MotionEvent.ACTION_DOWN)
    {
        v.playSoundEffect(SoundEffectConstants.CLICK);
        edLCD.setText(edLCD.getText().toString() + "1");
    }
    return true;
}