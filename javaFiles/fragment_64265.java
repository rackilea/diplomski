@Autowired
private ActorSystem actorSystem;

@Bean(name = "handler")
public ActorRef handler() {
    return actorSystem.actorOf(SpringExtProvider.get(system).props("Handler"), "handler");
}