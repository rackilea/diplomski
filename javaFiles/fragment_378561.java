public class Worker extends Bee {
    private Hive hive;
    private Garden garden;

    public Worker(Hive hive, Garden garden){
        super(hive);
        this.hive=hive;
        this.garden = garden;
        this.type = 2;
        this.age=11;
        this.health=3;
    }

    public void anotherDay(){
        Flower flower = garden.findFlower();
        flower.extractPollen(/* some value */);
        eat();
        age++;
    }
}