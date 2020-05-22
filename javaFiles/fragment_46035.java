private void acceptCall() {
    setHeadSetConnectEmulated();
    Intent buttonUP = new Intent(Intent.ACTION_MEDIA_BUTTON);
    buttonUP.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
    IncomingCallActivity.this.getApplicationContext().sendOrderedBroadcast(buttonUP, "android.permission.CALL_PRIVILEGED");
}

private void setHeadSetConnectEmulated(){
    Intent headSetUnPluggedintent = new Intent(Intent.ACTION_HEADSET_PLUG);
    headSetUnPluggedintent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY);
    headSetUnPluggedintent.putExtra("state", 1); // 0 = unplugged  1 = Headset with microphone 2 = Headset without microphone
    headSetUnPluggedintent.putExtra("name", "Headset");
    // TODO: Should we require a permission?
    sendOrderedBroadcast(headSetUnPluggedintent, null);
}

private void rejectCall() {
    Intent buttonDown = new Intent(Intent.ACTION_MEDIA_BUTTON);
    buttonDown.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK));
    IncomingCallActivity.this.getApplicationContext().sendOrderedBroadcast(buttonDown, "android.permission.CALL_PRIVILEGED");
}