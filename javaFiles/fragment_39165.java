public void onTextChanged(CharSequence s, int a, int b, int c) {
    //Parsing String to double
    double cercuils = Double.parseDouble(s.toString());
    double faherenheit = cercuils * 9/5 + 32;
    // faherenheit+"" -> converting double to String the easy way
    output.setText(faherenheit+"");
    if (a == 9) {
        Toast.makeText(getApplicationContext(),
                "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
    }
}