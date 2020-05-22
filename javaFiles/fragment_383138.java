if (usrObj.authenticateUser())
   {
        setContentView(R.layout.main_view);
        ButtonListener ();  << call here
   }
    else
        setContentView(R.layout.login);