final Bundle bundle = Platform.getBundle(id);
if (bundle != null)
 {
   if ((bundle.getState() & Bundle.ACTIVE) == 0)
    {
      try
       {
         bundle.start(Bundle.START_TRANSIENT);
       }
      catch (final BundleException ex)
       {
         // Handle error
       }
    }
 }