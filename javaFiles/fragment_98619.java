public Spinner addNewSpinner(int id, String[] vals) {

    sp = new Spinner(this);
    sp.setId(id);


    adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, vals);
    adapter.setDropDownViewResource((R.layout.multiline_spinner_dropdown_item));
    sp.setAdapter(adapter);

    linearLayout.addView(sp);

    return sp;
}