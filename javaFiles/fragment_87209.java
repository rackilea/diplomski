public class myTask extends AsyncTask<String,Void,String>{
       ConnectionDetector connectiondetector
       Context mcontext;
       public myTask(Context context)
         {
            mcontext= context;
            connectiondetector = new ConnectionDetector(mcontext);
         }

       @Override
     protected void onPreExecute() {

        super.onPreExecute();
        if(connectiondetector.isConnectingToInternet()){
          //dosomething  
         } 
     }