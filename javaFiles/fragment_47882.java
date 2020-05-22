WebDriver driver = new FirefoxDriver(); //or whatever you're using
boolean worked = false;
int numredos = 0;
final int REDO_LIMIT = 3; //or however many times you want to retry before giving up
final int RESTART_LIMIT = 3; //or however many times you want to restart the browser b/f terminating    
int numrestarts = 0;
boolean restart = false;
do
{
  try{

       if(restart)
       {
         driver = new FirefoxDriver();
         numrestarts++;
       }

    //RUN YOUR BROWSER CODE HERE
      worked = true;                                                        
     }

  //if the browser becomes unreachable (probably b/c of a socket issue), 
// write the error to the log and then sleep for 10 seconds
//if we've already retried the set limit number of times, restart the browser and try again
   catch (UnreachableBrowserException ube)
   {
     worked = false;
     if(numredos >= REDO_LIMIT)
     {
       //if you've already restarted the browser too many times, it will set it to null
       //and return an error code. If not, it will set the restart flag so it will be restarted on the next iteration.

         //try quitting. If it can't do it, it's already dead; just set it to null 
         //(set it to null either way, just in case)
          try
           {
            driver.quit();
           }
          catch(Exception j)
           {
            errorwriter.println(j);
           }

          driver = null;

          if(numrestarts < RESTART_LIMIT)
           {
             //log that you're restarting the driver (not coded here), then set the restart flag to true. This will cause the browser to be restarted after falling out of the catch block
             numredos = 0;
             restart = true;
           }

       }

      else
      {
        //print details of the exception to the error file
        errorfile.println("\n\n\n");
        //timestamp, and some exception details - you can decide which you want
        errorfile.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        errorfile.println(s.getClass());
        errorfile.println(s.getMessage());
        errorfile.println("Cause: " + s.getCause());
        errorfile.flush();

        //now sleep for some number of seconds - here 10
        try
        {
         TimeUnit.SECONDS.sleep(10);
        }

        catch(InterruptedException e)
        {
          System.out.println("waiting after socket crash interrupted");
        }

       numredos++;
      }

    }

}while(!worked && numredos <= REDO_LIMIT && numrestarts <= RESTART_LIMIT);