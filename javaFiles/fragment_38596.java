TextView intrebare = (TextView) findViewById(R.id.intrebare);
  Button buton = (Button) findViewById(R.id.button);
  final TextView rasplata = (TextView) findViewById(R.id.rasplata);

  buton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          final EditText raspuns = (EditText) findViewById(R.id.raspuns);
          if (raspuns.getText().toString().equals("Bucuresti")) {
              rasplata.setText("BRAVOO!!!");
          }
      }
  });