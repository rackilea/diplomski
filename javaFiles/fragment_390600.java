if(getIntent().getExtras() != null) {
   String orderNotification = getIntent().getStringExtra("orderNotification");  

  if (orderNotification.equals("orderNotification"))
            {
                TrackOrderFragment trackOrderFragment = new TrackOrderFragment();
                fragmentTransaction.replace(android.R.id.content, trackOrderFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }