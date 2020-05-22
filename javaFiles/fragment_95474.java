public abstract class AbstractVehicles implements Vehicles{
    protected AI ai;

    public AbstractVehicles(){
        AI ai = initAI();
    }

    protected abstract AI initAI(); // template method

    public void move(World w){
        ai.act(w); // But I have no idea this is CarAI or BicycleAI
    }
}