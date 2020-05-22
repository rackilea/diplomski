public class ConnectionActivity extends AppCompatActivity {
        Menu menu;
        private BroadcastReceiver mNetworkReceiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parser);
            mNetworkReceiver = new NetworkChangeReceiver();
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }

        @Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.internet, menu);
    this.menu = menu;
    this.menu.findItem(R.id.network_signal).setVisible(false);
    this.menu.findItem(R.id.network_signal_off).setVisible(false);
    return super.onCreateOptionsMenu(menu);
}

        public static void setMenuVisible(boolean isOnline) {
            if (isOnline) {
                if (menu != null) {
                    menu.findItem(R.id.network_signal).setVisible(true);
                    menu.findItem(R.id.network_signal_off).setVisible(false);
                }
            } else {
                if (menu != null) {
                    menu.findItem(R.id.network_signal_off).setVisible(true);
                    menu.findItem(R.id.network_signal).setVisible(false);
                }
            }
        }

        private void unregisterNetworkChanges() {
            try {
                unregisterReceiver(mNetworkReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            unregisterNetworkChanges();
        }
    }