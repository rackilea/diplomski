public class NetworkChangeReceiver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                try {
                    if (isOnline(context)) {
                        // show online icon
                        ConnectionActivity.setMenuVisible(true);
                    } else {
                       // show offline icon
                        ConnectionActivity.setMenuVisible(false);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean isOnline(Context context) {
                try {
                    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo netInfo = cm.getActiveNetworkInfo();
                    //should check null because in airplane mode it will be null
                    return (netInfo != null && netInfo.isConnected());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }