private String myInfo;

@Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString("KEY_MY_INFO", myInfo);
}