Vehicle v = new Car();
//v contains an instance of Car
Car c = v;
//a Car is not a Bike, this line will throw an error
Bike b = c;
//v2 contains an instance of Vehicle
Vehicle v2 = new Vehicle();
//a Car is a Vehicle
Car c2 = v2;
//a Bike is a Vehicle
Bike b2 = v2;