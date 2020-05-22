enum TriggerHandlerType {
    DASHBOARD(() -> DashboardTriggerHandler::new)),
    COMPONENT_HANDLER (() -> { ... });

    private final Fun fun;

    private TriggerHandlerType(Fun fun) {
        this.fun = fun;
    }

    public TriggerHandler create() {
        fun.apply();
    }
}