new SendRequest("scanContent").execute();

public class SendRequest extends AsyncTask<String, Void, String> {
    String scanContent;
    SendRequest(String scanContent){
        this.scanContent = scanContent;
    }
}

protected String doInBackground(String... arg0) {
    Log.d("SendRequest", scanContent);
}