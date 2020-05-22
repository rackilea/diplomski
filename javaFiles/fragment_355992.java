Bundle b = getIntent().getExtras();
if(b.getInt("requestCode") == 1){ //Richiesta modifica
    ((EditText) findViewById(R.id.editText_Time)).setText(String.valueOf(b.getInt("tempo")));
    ((EditText) findViewById(R.id.editText_Name)).setText(b.getString("nome"));
    //((EditText) findViewById(R.id.editText_URL)).setText(b.getString("url"));
    id_to_edit = b.getInt("id");
}