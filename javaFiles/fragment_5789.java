RandomImageHere.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        SharedPreferences pref = getSharedPreferences("Images", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        ed.putInt("IMG", R.drawable.picture);
        ed.apply();
        Intent intent = new Intent(getApplicationContext(), SecondClass.class);
        startActivity(intent);

    }
});