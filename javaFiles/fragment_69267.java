private static SupervisorStrategy strategy=
    new OneForOneStrategy(
    10,
    Duration.ofMinutes(1),
    DeciderBuilder.match(ArithmeticException.class,e->SupervisorStrategy.resume())
    .match(NullPointerException.class,e->SupervisorStrategy.restart())
    .match(IllegalArgumentException.class,e->SupervisorStrategy.stop())
    .matchAny(o->SupervisorStrategy.escalate())
    .build());
final ActorRef router=
        system.actorOf(
        new RoundRobinPool(5).withSupervisorStrategy(strategy).props(Props.create(Echo.class)));