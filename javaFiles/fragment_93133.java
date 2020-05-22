abstract class Vehicle
{
    abstract void move();
}

class Car extends Vehicle
{
    public void move() { ... }
}

class Ship extends Vehicle
{
    public void move() { ... }
}

public void moveVehicle(Vehicle v)
{
    v.move();
}