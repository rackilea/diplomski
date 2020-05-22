Intent intent=getIntent();
    Bundle extras=intent.getExtras();
    String message=extras.getString("EXTRA_MESSAGE_NAME");
    String message1=extras.getString("EXTRA_MESSAGE_AGE");
    String message2=extras.getString("EXTRA_MESSAGE_EMAIL");
    String message3=extras.getString("EXTRA_MESSAGE_PH");