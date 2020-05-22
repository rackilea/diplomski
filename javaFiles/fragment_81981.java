interface ISubject<T,O extends IObserver<T>> 
{
    void addObserver(O observer);
    void removeObserver(O observer);
    void updateAllSubjects(T value);

}
interface IObserver<T> 
{
    void update(T value);
}

class ConcreteObserver1<T> implements IObserver<T> 
{
    @Override
    public void update(T value) {}
}
class ConcreteObserver2<T> implements IObserver<T>
{
    @Override
    public void update(T value) {}
}
class ConcreteObserver3<T> implements IObserver<T>
{
    @Override
    public void update(T value) {}
}


class ConcreteSubject<T> implements ISubject<T,IObserver<T>>
{
    ConcurrentSkipListSet<IObserver<T>> observersList =
        new ConcurrentSkipListSet<IObserver<T>>();

    public ConcreteSubject()
    {
        addObserver(new ConcreteObserver1<T>());
        addObserver(new ConcreteObserver2<T>());
        addObserver(new ConcreteObserver3<T>());
    }

    @Override
    public void addObserver(IObserver<T> observer)
    {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(IObserver<T> observer)
    {
        observersList.remove(observer);
    }

    @Override
    public void updateAllSubjects(T value)
    {
        for (IObserver<T> observer : observersList)
        {
            observer.update(value);
        }
    }
}