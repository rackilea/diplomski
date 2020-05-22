public boolean isNetworkConnected(Context context)
    {
        if(context != null)
        {
            ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo ni = cm.getActiveNetworkInfo();
                if (ni == null) {
                    return false;
                } else
                    return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }