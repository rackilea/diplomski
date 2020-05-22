Intent intent = new Intent(this, DisplayResultActivit.class );
EditText edittext = findViewById(R.id.liczba);
EditText edittext2 = findViewById(R.id.liczba2);
int wpis2 = Integer.valueOf(edittext.getText().toString());
int wpis = Integer.valueOf(edittext2.getText().toString());
Bundle extras = new Bundle();
extras.putInt("wpis", wpis);
extras.putInt("wpis2", wpis2);

intent.putExtras(extras);

startActivity(intent);