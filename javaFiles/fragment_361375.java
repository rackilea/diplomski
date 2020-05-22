public KeyStore ks;

@Override protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try{
            // Get Keystore
            ks = KeyStore.getInstance(KeyStore.getDefaultType());

            SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
            boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
            if (isFirstRun)
            {
                SharedPreferences.Editor editor = wmbPreference.edit();
                editor.putBoolean("FIRSTRUN", false);
                editor.commit();

                ks.load(null, password);
                GenerateKey();
            } else {
                LoadKey();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        myClassNeedingTheKey.secretKey = key;
    }