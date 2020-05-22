interface RankerFactory {
    Ranker<A> getRankerForA(paramsForA);
    Ranker<B> getRankerForB(paramsForB);
    Ranker<C> getRankerForC(paramsForC);
    // ...
}

public abstract class AbstractRankerFactory {

    public Ranker<A> getRankerForA(paramsForA) {
        // ...default behavior...
    }

    public Ranker<B> getRankerForB(paramsForB) {
        // ...default behavior...
    }

    public Ranker<C> getRankerForC(paramsForC) {
        // ...default behavior...
    }
}

public class DefaultRankerFactory extends AbstractRankerFactory {}

public class CustomRankerFactory extends AbstractRankerFactory {

    @Override
    public Ranker<C> getRankerForC(paramsForC) {
        // ...custom behavior...
    }
}