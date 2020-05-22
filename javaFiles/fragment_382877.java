GoogleApiClient _gac;
com.google.api.services.drive.Drive _drvSvc;

public void init(MainActivity ctx, String email){
  // build GDAA  GoogleApiClient
  _gac = new GoogleApiClient.Builder(ctx).addApi(com.google.android.gms.drive.Drive.API)
        .addScope(com.google.android.gms.drive.Drive.SCOPE_FILE).setAccountName(email)
        .addConnectionCallbacks(ctx).addOnConnectionFailedListener(ctx).build();

  // build RESTFul (DriveSDKv2) service to fall back to for DELETE
  com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential crd =
  GoogleAccountCredential
    .usingOAuth2(ctx, Arrays.asList(com.google.api.services.drive.DriveScopes.DRIVE_FILE));
  crd.setSelectedAccountName(email);
  _drvSvc = new com.google.api.services.drive.Drive.Builder(
          AndroidHttp.newCompatibleTransport(), new GsonFactory(), crd).build();
}