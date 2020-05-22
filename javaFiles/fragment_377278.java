public class DataDownloader extends AsyncTask<Void,Void,Boolean>
{

 private ProgressDialog dialog;
public DataDownloader(SplashScreen context){
        this.context=context;

    }
@Override
    protected void onPreExecute() {
        super.onPreExecute();
        try {
            dialog = ProgressDialog.show(context, "Please wait", "Syncing Contact data..");
        }catch(Exception e){
            Log.e(AppConstants.NETLOG, "" + e.toString());
        }
    }
@Override
    protected Boolean doInBackground(Void... params) {
    //Do the required database query
return status;
    }
@Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(dialog!=null && dialog.isShowing())
        {
            dialog.dismiss();
        }
        if(!aBoolean){
            //Display error
        }else{
            //Process correct data
        }
    }
}