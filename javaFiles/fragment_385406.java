class MyActor extends AbstractActor {
    @Override
    Receive createReceive() {
        receiveBuilder()
            .match(DoSomething, { message ->
            // Implement message handler if message is of type DoSomething
            }).build()
    }
}