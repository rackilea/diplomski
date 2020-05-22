@Override
public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
    // TODO Auto-generated method stub
    BackLightValue = (float)arg1/100;

    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    layoutParams.screenBrightness = BackLightValue;
    getWindow().setAttributes(layoutParams);
}
@Override
public void onStartTrackingTouch(SeekBar arg0) {
}
@Override
public void onStopTrackingTouch(SeekBar arg0) {

    int SysBackLightValue = (int)(BackLightValue * 255);
    android.provider.Settings.System.putInt(getContentResolver(),
            android.provider.Settings.System.SCREEN_BRIGHTNESS,
            SysBackLightValue);
    }