GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
    .enableAutoManage(this /* FragmentActivity */,
                  this /* OnConnectionFailedListener */)
    .addApi(Drive.API)
    .addScope(Drive.SCOPE_FILE)
    .build();