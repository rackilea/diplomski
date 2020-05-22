@Override
public void onStop() {
    isInForgrand = false;
    super.onStop();
}
@Override
public void onResume() {
    super.onResume();
    isInForgrand = true;
}