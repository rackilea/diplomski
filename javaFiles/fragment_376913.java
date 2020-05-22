EditText inputName = (EditText) findViewById(R.id.inputnama);    

 button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if(inputName != null){
            String message = inputName.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("prefName", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", message);
            editor.apply();
            editor.commit();

            startActivity(new Intent(MainActivity.this, Quiz1Activity.class);
        }

    }});