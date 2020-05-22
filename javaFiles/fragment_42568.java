// First time you start TonosSet activity (without extra)
 // If you want to start TonosSet activity only once, comment two following line
 Intent tonosset = new Intent(Tonos.this, TonosSet.class);
 startActivity(tonosset);

 // Second time you start TonosSet activity (with extra this time)
 Intent i = new Intent(getApplicationContext(), TonosSet.class);
 i.putExtra("id", position);
 startActivity(i);