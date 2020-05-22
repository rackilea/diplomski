SharedPreferences sharedPref ;
    SharedPreferences.Editor editor;
    int i = sharedPref.getInt("background", -1);

    // before this , you cannot use the context reference ,it will be null
    public Backgrounds(Context context)
    {
       this.context = context
       // receive the context here and now you can safely use it
       sharedPref = context.getSharedPreferences("file", 0)
       editor = sharedPref.edit() 
  }