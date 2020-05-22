mCredential = GoogleAccountCredential.usingOAuth2(getApplicationContext(), Arrays.asList(SCOPES)).setBackOff(new ExponentialBackOff());
HttpTransport transport = AndroidHttp.newCompatibleTransport();
JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
mService = new com.google.api.services.gmail.Gmail.Builder(
        transport, jsonFactory, credential)
        .setApplicationName(mContext.getResources().getString(R.string.app_name))
        .build();