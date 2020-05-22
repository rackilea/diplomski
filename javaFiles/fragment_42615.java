private Observable observable = new Observable();

public void addObserver(Observer o) {
    observable.addObserver(o);
}

public void notifyObservers() {
    observable.notifyObservers();
}