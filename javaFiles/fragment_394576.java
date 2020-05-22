public class Observable {

    private List<IObserver> observers = new ArrayList<IObserver>();

    public void addObserver(IObserver observer){
        this.observers.add(observer);
    }

    public void execute(){
        for(int i = 0; i < 10000; i++){
            for(IObserver observer: observers){
                observer.notify(i);
            }
        }
    }
}