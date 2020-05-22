interface FactoryProvider<T> {
    public T getInstance();
}

class Concrete  implements FactoryProvider<Concrete> {

    @Override
    public Concrete getInstance() {
        return new Concrete();
    }
}