Vehicle [] vs = new Vehicle [2];

vs[0] = new Car();
vs[1] = new Ship();

for(Vehicle v : vs)
{
    moveVehicle(v);
}