import java.util.*;

class State
{
    static HashMap<String, State> states = new HashMap<String, State>();

    public static State Alabama = new State("Alabama", 0);

    public State(String name, int counter)
    {
        // [ init... ]
        states.put(name, this); // add this state to the collection of states
    }

    public static State getByName(String name)
    {
        return states.get(name);
    }
}