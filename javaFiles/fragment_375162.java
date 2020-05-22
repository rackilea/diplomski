public MainActivity extends Activity implements OnAsyncFinished {
     @Override
     public void onAsyncFinished(Object o) {
         //This will get called after onPostExecute, do what u want with the object you got from onPostExecute, json or string in ur example
         profileDefaults(); //call ur function
     }
}