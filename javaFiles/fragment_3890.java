@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.connection_type:

            // Creates an alert dialog where the user can choose which connectivity technology to monitor
            final CharSequence connectionsType[] = new CharSequence[]{"GSM", "UMTS", "LTE", "WIFI"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setTitle("Choose a wireless technology");
            builder.setItems(connectionsType, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Unregister active connectivity related receiver
                    unregisterProperReceiver(ACTIVE_CONNECTIVITY_TYPE);
                    if(marker != null) {
                        marker.hideInfoWindow();
                        marker = null;
                    }
                    // Clear map
                    mMap.clear();  /* devil is here */
                    ....


 // When the info windows  is closed delete the associated marker
        mMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
            @Override
            public void onInfoWindowClose(Marker marker) {
                marker.remove();

            }
        });