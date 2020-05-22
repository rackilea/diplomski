@Singleton
public class StateManager {
    private Map<StateType, StateHandler> stateHandlerMap;
    private StateType stateType = StateType.DEFAULT;

    @Inject
    public StateManager(Map<StateType, StateHandler> stateHandlerMap) {
        this.stateHandlerMap = stateHandlerMap;
    }

    public void changeState(StateType newStateType) {
        if (stateType != newStateType) {
            stateHandlerMap.get(stateType).onDeactivation();
            stateType = newStateType;
            stateHandlerMap.get(stateType).onActivation();
        }
    }
}