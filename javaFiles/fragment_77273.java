private class Car{
    private Engine engine;
    private ArrayList<Tire> tires; 

    public void setEngine(Engine carEngine){
        this.engine = carEngine;
    }
    public Engine getEngine(){
        return this.engine;
    }
    public void addTire(Tire carTire){
        this.tires.add(carTire);
    }
}