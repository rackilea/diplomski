public class MyActivity extends Activity {
  // To store the Bitmap returned by doInBackground asynctask
  private Bitmap result;
  // existing Activity code
  ...

  private class GetBitmapFromURLAsync extends AsyncTask<String, Void, Bitmap>   {
    @Override
    protected Bitmap doInBackground(String... params) {
      return getBitmapFromURL(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
      //  return the bitmap by doInBackground and store in result
      result = bitmap;
    }
}