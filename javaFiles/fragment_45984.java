class TheTask extends AsyncTask<Void,Void,Void>
   {
       @Override
       protected void onPreExecute()
       {
               super.onPreExecute();
               // dispaly progress dialog 
       } 
       @Override
       protected void doInbackground(Void... params)
       {
           // do network related operation here
           // do not update ui here
          return null; // return result here
       } 
       @Override
       protected void onPostExecute(Void result) // result of background computation received
       {
           super.onPostExecute(result);
            // dimiss dialog
           // update ui here     
       } 
   }