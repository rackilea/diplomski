mGoogleApiClient = new GoogleApiClient.Builder(this.cordova.getActivity())
                                .addApi(Wallet.API, new Wallet.WalletOptions.Builder()
                                    .setEnvironment(WALLET_ENVIRONMENT)
                                    .build())
                                .addConnectionCallbacks(this)
                                .addOnConnectionFailedListener(this)                            
                                .build();               

// Connect to google api client
mGoogleApiClient.connect();