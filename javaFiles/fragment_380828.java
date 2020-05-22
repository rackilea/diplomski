// remove static
int speed;
public Bicycle(String[] vehicleData) {
    super(vehicleData);
    speeds = Integer.valueOf(vehicleData[0]);
}