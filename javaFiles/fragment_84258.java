public class Net {

  public Net (Context ctx) {
    cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    netInfo = cm.getActiveNetworkInfo();
  }

  // Your other methods here...
}