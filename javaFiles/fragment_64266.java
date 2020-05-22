@Named("Reader") 
   @Scope("prototype")
   public class Reader extends UntypedConsumerActor {

        @Autowired
        @Qualifier("handler")
        private ActorRef handler;

        // ...
    }