Intent weiter  = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(weiter);

            EditText EingabeBreite = (EditText)findViewById(R.id.breite);

            double breite = Double.parseDouble(EingabeBreite.getText().toString());

            Intent rüber = new Intent(getApplicationContext(),MainActivity.class);
            getIntent().putExtra("next","breite");
            startActivity(rüber);