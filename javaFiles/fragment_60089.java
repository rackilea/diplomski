public class ExampleAsync extends AsyncTask <Void, Integer, Void> {

     private ProgressDialog progressBar; //to show a little modal with a progress Bar
 private Context context;  //needed to create the progress bar

     public ExampleAsync(Context context){
           this.context = context;
     }

     //this is called BEFORE you start doing anything 
     @Override 
     protected void onPreExecute(){
         progressBar = new ProgressDialog(context);
         progressBar.setCancelable(false);
         progressBar.setMessage("I am starting to look for stuff");
         progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
         progressBar.setIndeterminate(true);
         progressBar.show();
     }

     //every time you call publishProgress this method is executed, in this case receives an Integer
     @Override
 protected void onProgressUpdate(Integer ... option){
         progressBar.setMessage("I have found :" + option[0]);      
}  

     @Override
 protected void onPostExecute(Void unused){     
      progressBar.dismiss(); //hides the progress bar
          //do whatever you want now
}



     //in here is where you execute your php script or whatever "heavy" stuff you need
     @Override
 protected Void doInBackground(Void... unused) {          
        for (int i = 0; i < someLimit; i++){
             //do something
             publishProgress(i); //to show the progress
        }
     } 




 }