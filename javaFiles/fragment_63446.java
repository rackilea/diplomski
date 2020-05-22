public class Client{
      /************************************
       This receiver is created by constructor
      **************************************/
      @Inject
      Receiver receiver1;

      /************************************
      This receiver is created by producer method  
       **************************************/
      @Inject
      @SendInject(999)
      Receiver receiver2;
}