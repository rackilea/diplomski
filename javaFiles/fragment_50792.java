class TheTask extends AsyncTask<Void,Void,Void>
  {
      protected void onPreExecute()
      {           super.onPreExecute();
                //display progressdialog.
      } 

       protected void doInBackground(Void ...params)
      {  
            //Network related opearaiton. Do not update ui here

            return null;
      } 

       protected void onPostExecute(Void result)
      {     
                super.onPostExecute(result);
                //dismiss progressdialog.
                //update ui
      } 

}