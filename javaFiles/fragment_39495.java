public class App
  {
    // Create the instance
    private static App instance;
    public static App getInstance()
    {
         if (instance== null) {
                synchronized(App.class) {
                        if (instance == null)
                                instance = new App();
                        }
                }
                // Return the instance
                return instance;
    }

    private App()
    {
        // Constructor hidden because this is a singleton
    }

    public void initFBSdk()
    {
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}