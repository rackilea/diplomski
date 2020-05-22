List<AuthUI.IdpConfig> providers = Collections.singletonList(
                        new AuthUI.IdpConfig.EmailBuilder().setAllowNewAccounts(true).build());

startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setLogo(your app logo)
                                .setAvailableProviders(providers)
                                .build(),
                        LOGIN_PERMISSION);