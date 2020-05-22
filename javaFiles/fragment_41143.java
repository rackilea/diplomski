public class Elevator implements Runnable
{    
    private List<Integer> floors = new ArrayList<Integer>();
    private int startingFloor = 0;

    //add floor into Arraylist
    public void addFloor(int floor)
    {
        floors.add(floor);
        System.out.println("Added to floor array\n");
        System.out.println(floors);
    }

    public void setStartingFloor(int floor){
        this.startingFloor = floor;
    }

    public void run()
    {

    }

    public void sortFloors()
    {
        Collections.sort(floors);
    }

    public void printFloors()
    {
        System.out.println(floors);
    }
}