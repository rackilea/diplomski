public void createSpinners()
   {

      final DataHelper db = new DataHelper(getApplicationContext());
      final List<String> labelKolom = db.getKolom();

      spnKolom = new Spinner[labelKolom.size()];

      for (int itung=0;itung<labelKolom.size();itung++)
      {
           spnKolom[itung] = new Spinner(this);
           spnKolom[itung].setTag(itung);

           ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labelKolom);
           spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          spnKolom[itung].setAdapter(spinnerArrayAdapter);
          spnKolom[itung].setOnItemSelectedListener(this);

          if(itung == 0)
          {
             spnKolom[itung].setVisibility(View.VISIBLE);
          }
          else
          {
             spnKolom[itung].setVisibility(View.GONE);
          }

          mainSpinnerLayout.addView(spnKolom[itung]);
     }
}