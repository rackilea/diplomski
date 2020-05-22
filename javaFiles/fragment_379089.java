public void ergebnissFromel(View v) {

    Spinner feld4 = (Spinner) findViewById(R.id.spinner1);

    Integer zahl1 = 0;
    Integer zahl2 = 0;
    Integer zahl3 = 0;

    try
    {
        zahl1 = Integer.parseInt(gewichtinput.getText().toString());
        zahl2 = Integer.parseInt(winkelinput.getText().toString());
        zahl3 = Integer.parseInt(stfinput.getText().toString());
    } catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
    }

    String spinner = feld4.getSelectedItem().toString();


    if ( zahl1.equals("") || zahl1 == null){
        Toast.makeText(this, "Bitte geben Sie das Gewicht an", Toast.LENGTH_SHORT).show();

    }
    if ( zahl2.equals("") || zahl2 == null){
        Toast.makeText(this, "Bitte geben Sie das Gewicht an", Toast.LENGTH_SHORT).show();

    }

    if ( zahl3.equals("") || zahl3 == null){
        Toast.makeText(this, "Bitte geben Sie das Gewicht an", Toast.LENGTH_SHORT).show();

    }
    else {

        // Grad wird in sinus alpha umgerechnet
        double newsinus = Math.sin(Math.toRadians(Float.valueOf(zahl2)));

        double wert1 = cX - Float.valueOf(spinner) * cZ;
        double wert2 = Float.valueOf(spinner) * newsinus;

        // Formel Niederzurren Algorithmus
        double wert3 = wert1 * zahl1;
        double wert4 = wert2 * k;
        double wert5 = wert3 / wert4;
        double wert6 = Math.round(wert5);
        double wert7 = wert6 / zahl3;
        double wert8 = Math.ceil(wert7);

        ergebnissFeld.setText(String.valueOf(Math.round(wert8)));

    }
}