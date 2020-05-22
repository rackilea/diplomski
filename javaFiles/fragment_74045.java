Fragmentclass or Activity:

private void onButtonClick() {
  ...
  RemoteClient rc = new RemoteClient(value, (response) -> {
     Log.d(response);
  };
  rc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
  ...
}

public class RemoteClient extends AsyncTask<Void, Void, Void> {
  private Callback callback;
  private int intValue;

  public RemoteClient(int intValue, Callback callback) {
    this.callback = callback;
    this.intValue = intValue;
  }

  @Override
  protected Void doInBackground(Void... arg0) {
      Log.i("Socket","Connecting to the remote server: " + host);
      try{
        socket = new Socket(host,8025);
        oos = new ObjectOutputStream(socket.getOutputStream());
        sendInteger(intvalue);
      } catch(IOException ex){
        ex.printStackTrace();
      }
      return null;

  }

  private void sendInteger(int value) {
    // send the integer
  }

  protected void onPostExecute(Void aVoid) { 
    if (callback != null) {
       callback.response;
    }
  }

private interface Callback {
  void serverResponse(String value);
}
}