public class RefDataInInterceptor extends AbstractPhaseInterceptor<Message> {
   private static final Logger log = 
      LogManager.getLogger(RefDataInInterceptor.class);

   public RefDataInInterceptor() {
      super(Phase.RECEIVE);
   }

   @Override
   public void handleMessage(Message msg) throws Fault {
      log.info(msg.getContextualProperty(Message.REQUEST_URL));
   }
}