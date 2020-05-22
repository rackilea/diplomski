@Override
public void onDestroy() {
    super.onDestroy();
    Intent i = new Intent(this, ActivityName.class);
    startActivtiy(i);
}