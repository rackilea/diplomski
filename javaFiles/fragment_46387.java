int destination = rand1.nextInt(4) + 1;
if (destination >= currentFloor) {
    destination++;
}
destElevator.add(destination)
System.out.println(destElevator);