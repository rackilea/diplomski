private void load() {
    SharedPreferences sharedPreferences = getSharedPreferences("colour", 0);
    String colour = sharedPreferences.getString("colour", null);

    if (colour == null)
        colourPicker.check(R.id.radioOrange);  //Default if no preference exists
    else if (colour.equals("orange")) {
        colourPicker.check(R.id.radioOrange);
    } else if (colour.equals("lilac")) {
        colourPicker.check(R.id.radioLilac);
    } else if (colour.equals("red")) {
        colourPicker.check(R.id.radioRed);
    } else {
        colourPicker.check(R.id.radioTeal);
    }
}