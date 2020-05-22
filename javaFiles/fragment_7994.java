AppUtils.EVENT_BUS.addHandler(AuthenticationEvent.TYPE, new AuthenticationEventHandler()     {
        @Override
        public void onAuthenticationChanged(AuthenticationEvent authenticationEvent) {
            // authentication changed - do something
        }
    });