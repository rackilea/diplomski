[...]

else if (id == R.id.nav_videovorschlag) {
          if(isOnline){
setTitle("Videovorschlag");
                Fragment5_vorschlag fragment = new Fragment5_vorschlag();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frag_home, fragment, "Videovorschlag");
                fragmentTransaction.commit();
             }
            }

public boolean isOnline() {
                ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

                if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
                    return false;

                    ImageButton internetok;
                    offlineDialog.setContentView(R.layout.onlinepopup);
                    internetok = (ImageButton) offlineDialog.findViewById(R.id.internetok);
                    internetok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            offlineDialog.dismiss();
                        }
                    });
                }
                return true;
}