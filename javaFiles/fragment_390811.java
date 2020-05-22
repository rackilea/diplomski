public class Building{
    private int floor = 0;

    private ArrayList<Floor> floors = new ArrayList<Floor>();

    public Buliding(){
        Floor floor1 = new Floor(this);
        this.floors.add(floor1);
    }

    public Floor floor(int floorNumber) {
        this.floor = floorNumber;
        return floors.get(floorNumber);
    }

    public int getFloor(){
        return floor;
    }
}