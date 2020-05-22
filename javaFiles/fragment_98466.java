@Override
public void onSaveInstanceState(Bundle outState) {

    outState.putBoolean("EXTRA_IS_ON", isOn);
    super.onSaveInstanceState(outState);
}