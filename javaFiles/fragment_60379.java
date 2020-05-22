public void onClick(DialogInterface dialog,int id)
   {                                                                        

       stopService(new Intent(<InsertYourActivityClassName>.this, Service.class));
       finish();                               

  }