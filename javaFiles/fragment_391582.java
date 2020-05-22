public void connect(View v) { 
      new TheTask().execute();
}
class TheTask extends Asynctask<Void,Void,Void>
{
 @Override
 protected Void doInBackground(Void... params) {
   HttpClient client = new DefaultHttpClient();
   HttpGet request = new HttpGet("http://www.yiinotes.com/nutrimondo/web/meals/week");
    try {
        client.execute(request);
    } catch (IOException e) {
        e.printStackTrace();
    }
   return null; 
 }
}