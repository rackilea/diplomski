Toast t = Toast.makeText(....., YERY_LONG_TOAST_TIME);
t.show();

public void onYourTaskFinished() {
    t.cancel();
}