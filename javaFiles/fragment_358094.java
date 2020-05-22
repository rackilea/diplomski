private void initializeApplication() {
        awsConfiguration = new AWSConfiguration(this);

        if (IdentityManager.getDefaultIdentityManager() == null) {
            final IdentityManager identityManager = new IdentityManager(getApplicationContext(), awsConfiguration);
            IdentityManager.setDefaultIdentityManager(identityManager);
        }


        FacebookSignInProvider.setPermissions("public_profile");

        // Add Facebook as an SignIn Provider.
        IdentityManager.getDefaultIdentityManager().addSignInProvider(FacebookSignInProvider.class);

        GoogleSignInProvider.setPermissions(Scopes.EMAIL, Scopes.PROFILE);

        // Add Google as an SignIn Provider.
        IdentityManager.getDefaultIdentityManager().addSignInProvider(GoogleSignInProvider.class);


        try {
            final PinpointConfiguration config =
                    new PinpointConfiguration(this,
                            IdentityManager.getDefaultIdentityManager().getCredentialsProvider(),
                            awsConfiguration);
            Application.pinpointManager = new PinpointManager(config);
        } catch (final AmazonClientException ex) {
            Log.e(LOG_TAG, "Unable to initialize PinpointManager. " + ex.getMessage(), ex);
        }

        // The Helper registers itself to receive application lifecycle events when it is constructed.
        // A reference is kept here in order to pass through the onTrimMemory() call from
        // the Application class to properly track when the application enters the background.
        applicationLifeCycleHelper = new AbstractApplicationLifeCycleHelper(this) {
            @Override
            protected void applicationEnteredForeground() {
                Application.pinpointManager.getSessionClient().startSession();
                // handle any events that should occur when your app has come to the foreground...
            }

            @Override
            protected void applicationEnteredBackground() {
                Log.d(LOG_TAG, "Detected application has entered the background.");
                Application.pinpointManager.getSessionClient().stopSession();
                Application.pinpointManager.getAnalyticsClient().submitEvents();
                // handle any events that should occur when your app has gone into the background...
            }
        };
    }