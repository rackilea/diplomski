interface Vehicle{
}

class Car implements Vehicle{
}

class Truck implements Vehicle{
}

List<Vehicle> list = new ArrayList<Vehicle>();
list.add(new Car());
list.add(new Truck());