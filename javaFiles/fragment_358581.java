import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

class StackOverflowQuestion57661787 {
    enum StateType {
        PENDING,
        ACTIVE,
        DONE
    }

    //Made the name explicit here to ease readability
    public interface Transition extends Function<State, State> { }

    public static class State {
        public StateType type;
        //TODO: some real data to manipulate, or make it immutable
        public Object data;
    }

    public static class StateMachine {
        private final Map<StateType, Map<StateType, Transition>> transitions =
                new EnumMap<>(StateType.class);
        private State state;

        public StateMachine(State initialState) {
            this.state = initialState;
            for (StateType value : StateType.values()) {
                transitions.put(value, new EnumMap<>(StateType.class));
            }
        }

        public void addTransition(
                StateType input,
                StateType output,
                Transition transition
        ) {
            //TODO: handle collisions? multiple transitions for a given 
            // output statetype seems like a strange use-case
            transitions.get(input).put(output, transition);
        }

        public void moveTo(StateType toType) {
            Transition transition = transitions.get(state.type).get(toType);
            if (transition == null) {
                //TODO: handle me
                throw new RuntimeException();
            }
            //transition should modify the states "type" too OR
            //you implement it here
            state = transition.apply(state);
        }

        public State getState() {
            return state;
        }
    }
}