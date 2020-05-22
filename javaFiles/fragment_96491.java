public void showWebPage(Context mContext) {

    String url = "https://www.google.com";
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    try {
        mContext.startActivity(i);
    } catch (Exception e) {
        Log.d ("myError", e.getMessage());
    }
}