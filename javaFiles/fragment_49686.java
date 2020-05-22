@Named
@Scope("prototype")
public class StateOne extends AbstractStateActorActor<StatObject> {

    @Inject
    public StateOne(final Props prop, final StatRegistry statRegistry) {
        super("test", transformationConfig, GenericStateObject.class, statRegistry);
    }
}