public static void First_function(Context context)
  {
    SMS sms = new SMS();
    sms.Second_function(context);
  }

  public void Second_function(Context context)
  {
    Toast.makeText(context,"Hello",1).show(); // This i anable to display and cause crash
  }