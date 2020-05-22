@Service //Also @Component is a good alternative
public class SmDpES2PortImpl implements ES2SmDp {
    @Autowired
    private IMockWS mock; //Notice that you are wiring an interface

    @Override
    public void es2DownloadProfile(ES2DownloadProfileRequest parameters) {
         try {
            LOG.info("\n\n\n TEST BEAN: " + mock.callSoapClient() + "\n\n");
          }
     }  
}