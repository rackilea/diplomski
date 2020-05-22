@Override
public void onPause()
{
    super.onPause();
    timer.cancel();    // timer is a reference to my inner CountDownTimer class
    timer = null;
}