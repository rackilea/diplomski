try
    {

     killProcess();


     try {
              Thread.sleep(1000);
         }    catch(InterruptedException ex) 

         {
              Thread.currentThread().interrupt();
         }



     Runtime.getRuntime().exec("c:\\Temp\\osk.exe");

    }
    catch ( Exception ex )
    {
        ex.printStackTrace();
    }

                    }