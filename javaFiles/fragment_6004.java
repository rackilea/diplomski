public boolean isInternetAvailable(Context context)
{
    NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
        context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

    if (info == null){
        return false;
    }
    else{
        return true;
    }
}