import java.util.List;

public abstract class Observable<T extends Observable<T>> {
    private List<Observer<T>> observers;

    public Observable() {
        System.out.println(this.getClass());
    }

    public void addObserver(Observer<T> obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer<T> obs) {
        observers.remove(obs);
    }

    protected  void updateObservers(T self) {
        for (Observer<T> obs : observers) {
            obs.update(self);  
        }
    }
}