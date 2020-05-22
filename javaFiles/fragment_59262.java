public class Movement {

    RegulatedMotor left;
    RegulatedMotor right;
    EV3TouchSensor touchSensor;
    EV3ColorSensor colorSensor;
    EV3GyroSensor gyroSensor;
    EV3UltrasonicSensor ultrasonicSensor;

    // like in your code, sensors is still a field, but won't be initialized yet
    Sensors sensors;

    public Movement(RegulatedMotor l, RegulatedMotor r, EV3TouchSensor t,  EV3ColorSensor c, EV3GyroSensor g,
            EV3UltrasonicSensor u) {
        left = l;
        right = r;
        touchSensor = t;
        colorSensor = c;
        gyroSensor = g;
        ultrasonicSensor = u;

        // here is the initialization of sensors - at this point, the arguments shouldn't be null anymore (unless they are passed as null to the constructor)
        sensors = new Sensors(touchSensor, colorSensor, gyroSensor, ultrasonicSensor);
    }

    public void moveForward() {
        // this method should be okay, you don't need to change it

        // ...
    }