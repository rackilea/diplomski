public class Building implements Serializable {
    private BuildingTypes type;

    public Building(BuildingTypes type) {
        this.type = type;
    }

    // Added Constructor 
    public Building() {
    }

    public BuildingTypes getType() {
        return type;
    }   
}