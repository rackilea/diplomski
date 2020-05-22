@Override
public void onBackPressed() {

    EditText et = (EditText)findViewById(R.id.yourEditText);
    if (et.length() > 0) {
        saveAndFinish();
    }
    super.onBackPressed();
}