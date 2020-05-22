abstract class AbstractCar {
    protected abstract void startEngine();
}

class FastCar extends AbstractCar {
    @Override
    public void startEngine() {
        System.out.println("turn key... vroom");
    }
}