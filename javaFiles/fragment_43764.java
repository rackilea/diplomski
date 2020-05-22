@Autowired
StateMachineFactory<String, String> factory;

    public void getOrderStatus(long id) {
        StateMachine<String, String> stateMachine = factory.getStateMachine();
        stateMachine.start();
        stateMachine.sendEvent();
    }