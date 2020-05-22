public boolean checkBeginnTime() {
    EditText EtimpAnfang = (EditText) findViewById(timpAnfang);
    if (EtimpAnfang.getText().toString().length() == 0) {
        EtimpAnfang.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(EtimpAnfang, InputMethodManager.SHOW_IMPLICIT);
        EtimpAnfang.setError(getString(R.string.ErrStringAnfangZeitMissing));
        return false;
    }
    return true;
}