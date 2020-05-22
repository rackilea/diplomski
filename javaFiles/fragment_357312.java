public class Observable
{
    public event Action<object, object> OnStateChange;

    public void Event()
    {
        // do something
        // choose appropritate args
        OnStateChange.Invoke(null, null);
    }

    /* versus ************************************************/
    Observator[] observators;
    public void InformObservators()
    {
        foreach (Observator observator in observators)
            // choose appropritate args
            observator.UpdateState(null, null);
    }
}

public class Observator
{
    public Observator(Observable observable)
    {
        observable.OnStateChange += UpdateState;
    }
    /* versus ************************************************/
    public void UpdateState(object arg1, object arg2)
    {

    }
}