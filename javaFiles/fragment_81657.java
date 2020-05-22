Bundles extras = getIntent().getExtras();
 String i1 = extras.getString( "i1" );
        String i2 = extras.getString( "i2" );
    Intent myIntent = new Intent(getBaseContext(), UserManual.class); 
myIntent.putExtra("i1", i1); 
myIntent.putExtra("i2", i2); 
myIntent.putExtra("i3", regno); 
myIntent.putExtra("i4", dob);
 startActivityForResult(myIntent, 0);