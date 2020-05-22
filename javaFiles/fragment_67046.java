public class Bicycle {
    private int speed, gear, cadence;
    /**
     * Default constructor
     */
    public Bicycle() {
        speed = 0;
        gear = 1;
        cadence = 0;
    }
    /**
     * An example 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
        /*
           You can set the value of the other attributes here if you want to
         */
    }
    /**
     * Another example
     */
    public void gearUp() {
        if(gear < 5)
            gear++;
        /*
           Here you are preventing other methods to set the gear to
           a value higher than 5.
         */
    }
    /**
     * Another one
     */
    public void gearDown() {
        if(gear > 1)
            gear--;
        /*
           Here you are preventing other methods to set the gear to
           a value lower than 1.
         */

    }
}