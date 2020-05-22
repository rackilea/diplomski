public static void main(String args)
{
    ArrayList<Bicycle> group = new ArrayList<Bicycle>();
    group.add(new RoadBike());
    group.add(new MountainBike());
    // ... add more...

    // tell the class to take a pee break
    for (Bicycle bicycle : group) bicycle.ride();
}