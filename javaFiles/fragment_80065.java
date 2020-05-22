public void onClick(View v) {
    // TODO Auto-generated method stub
    contatore++;
    display.setText("Il totale è: "+ contatore);

    if (contatore > 10) {
        immagine.setVisibility(View.VISIBLE);
    }
  }