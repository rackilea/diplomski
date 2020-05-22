minus1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        getdisplay2 = pref.getString("display2", "");
        float AP = NumberUtils.toFloat(getdisplay2);
        display2.setText(Float.toString(AP - 1));

        SharedPreferences.Editor editor=pref.edit();
        editor.putString("display2", display2.getText().toString());
        editor.commit();
    }
});