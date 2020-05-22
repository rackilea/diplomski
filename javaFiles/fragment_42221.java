import java.util.ArrayList;

class State{}

class Framework<State> 
{
    public ArrayList< Action< ? super State > >actions = new ArrayList< Action< ?super State > >();

    void add(Action<? super State> a) {

        actions.add(a);

    } 

    void doRun(State s) {
        for(Action<? super State> a : actions) {
            a.perform(s);
        }
    }
}

interface IState1 {}

interface IState2 {}

interface Action<State> {
    public void perform(State s);
}

class Action1 implements Action<IState1> {
    public void perform( IState1 s )
    {
        System.out.println("Do something 1");
    }
}

class Action2 implements Action<IState2> {

    public void perform( IState2 s )
    {
        System.out.println("Do something 2");
    }   
}

class CombinedState implements IState1, IState2 {}

class Untitled {
    public static void main(String[] args) 
    {
         Framework<CombinedState> f = new Framework<CombinedState>();

            // add is expecting Action<? super CombinedState> but getting Action<IState1>
            f.add(new Action1()); // This doesn't seem to work
            f.add(new Action2());

            f.doRun(new CombinedState());
    }
}