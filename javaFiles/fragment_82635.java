public class CustLogInInterceptor extends AbstractSoapInterceptor {


    public CustLogInInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {

        HttpServletRequest httpRequest = (HttpServletRequest) message.get ( AbstractHTTPDestination.HTTP_REQUEST );
        LoggerUtil.setLog(CustLogInInterceptor.class , LogConstants.DEBUG, "Request From the address : " + httpRequest.getRemoteAddr ( ) );

        try
        {
            //Handle you custom code add log it
              LoggerUtil.setLog(CustLogInInterceptor.class , LogConstants.DEBUG, "Log here" );
        }

        catch ( Exception ex )
        {
            ex.printStackTrace ( );
        }



    }

}