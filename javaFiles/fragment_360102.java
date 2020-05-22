private void testLogin(){
        ConnectionConfiguration config = new ConnectionConfiguration("chat.facebook.com", 5222);
        config.setSASLAuthenticationEnabled(true);
        config.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
        xmpp = new XMPPConnection(config);
        SASLAuthentication.registerSASLMechanism("X-FACEBOOK-PLATFORM",SASLXFacebookPlatformMechanism.class);
        SASLAuthentication.supportSASLMechanism("X-FACEBOOK-PLATFORM", 0);
        Log.i("XMPPClient",
                "Access token to " + mFacebook.getAccessToken());
        Log.i("XMPPClient",
                "Access token to " + mFacebook.getAppId());
        Log.i("XMPPClient",
                "Access token to " + mFacebook.getAccessToken());
        try {
            xmpp.connect();
            Log.i("XMPPClient",
                    "Connected to " + xmpp.getHost());

        } catch (XMPPException e1) {
            Log.i("XMPPClient",
                    "Unable to " + xmpp.getHost());

            e1.printStackTrace();
        }
        try {
            xmpp.login(PreferenceConnector.APP_ID, mFacebook.getAccessToken());

            getRoster(xmpp);


        } catch (XMPPException e) {
            e.printStackTrace();
        }  
    }