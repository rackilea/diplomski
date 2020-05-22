public class MainActivity extends CordovaActivity
  {
      @Override
      public void onCreate(Bundle savedInstanceState)
      {
          super.onCreate(savedInstanceState);
          if (!LibsChecker.checkVitamioLibs(this))
          return;
              // Set by <content src="index.html" /> in config.xml
              loadUrl(launchUrl);
       }
  }