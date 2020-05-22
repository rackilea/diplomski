Bundle extras = getIntent().getExtras();
     if (extras != null) 
     {
     String Number = extras.getString("Num");
     String Message = extras.getString("Mess");
     values.add(Number);
     }