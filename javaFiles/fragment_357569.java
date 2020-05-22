interface RankerFactory {

    default Ranker<A> getRankerForA(paramsForA) {
        // ...default behavior...
    }

    default Ranker<B> getRankerForB(paramsForB) {
        // ...default behavior...
    }

    default Ranker<C> getRankerForC(paramsForC) {
        // ...default behavior...
    }

    // ...
}

public class DefaultRankerFactory implements RankerFactory {}

public class CustomRankerFactory implements RankerFactory {

    @Override
    public Ranker<C> getRankerForC(paramsForC) {
        // ...custom behavior...
    }
}