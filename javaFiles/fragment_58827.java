package it.ant.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<IObserver<?>> observers = new ArrayList<>();
        IObserver<String> stringObserver = new Observer<>();
        IObserver<Integer> integerObserver = new Observer<>();
        stringObserver.addObserved("we are ");
        integerObserver.addObserved(2);

        observers.add(stringObserver);
        observers.add(integerObserver);

        for (IObserver<?> o : observers) {
            System.out.print(o.getObserved());
        }

    }
}

interface IObserver<T> {    
    void addObserved(T t);
    T getObserved();
}

class Observer<T> implements IObserver<T> { 
    private T observed;

    @Override
    public void addObserved(T observed) {
        this.observed = observed;

    }

    @Override
    public T getObserved() {
        return observed;
    }
}