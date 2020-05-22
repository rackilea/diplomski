public class ItemData {

    private String name;
    private double cost;
    private int priority;

    public ItemData(String name, double cost, int priority){
        this.name = name;
        this.cost = cost;
        this.priority = priority;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    public int getPriority(){
        return this.priority;
    }
}