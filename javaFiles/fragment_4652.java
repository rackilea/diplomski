public yourActivity extends Activity implements OnResponseReceivedListener {


    ServerConnection conn = new ServerConnection(this);
    conn.setResponseListener(this);

    public void onResponseReceived(String response){

     // TODO: do your UI operations based on the response.
    }
}