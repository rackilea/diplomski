public class MATLABConnector
{
      private MATLABConnector con=new MATLABConnector();
      MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
        .setUsePreviouslyControlledSession(true)
        .setHidden(true)
        .setMatlabLocation(null).build();

      MatlabProxyFactory factory = new MatlabProxyFactory(options);

      private MATLABConnector() 
      {
            // Do basic initializations.
      }        

      private boolean checkConnecionStatus();
      private boolean establishConnection();
      public static MATLABProxy getProxy()
         {
              if(!con.checkConnectionStatus())
                    con.establishConnection();
              return con.factory.getProxy();
         }
  }