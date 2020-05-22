public class LunarLander {

    double Altitude;
    double verticalSpeed;
    double fuelLeft;

    public LunarLander(double Altitude, double verticalSpeed, double fuelLeft){
        this.Altitude = Altitude;
        this.verticalSpeed = verticalSpeed;
        this.fuelLeft = fuelLeft;
    }

    public void move(double efficiency, int maxFuel,
            int time, double inputFuelRate) {
        // formulas to change outputs
        double velocity = time * (efficiency - 1.62); // given formula to
                                                        // caluculate velocity
        double altChng = time * velocity; // creates a variable for atitude
                                            // chage

        // exceptions
        if (efficiency > 0 && fuelLeft == 0) { // changes efficiency to 0 when
                                                // there is no fuel left
            efficiency = 0;
        } else {
        }

        // new outputs
        Altitude = Altitude - altChng; // calculates new altitude by subtracting
                                        // altitude change
        velocity = time * (efficiency - 1.62); // given formula to caluculate
                                                // velocity
        altChng = time * velocity; // creates a variable for atitude chage
        verticalSpeed = velocity; // since the ship would only move and
                                            // not go back and forth velocity is
                                            // speed

        efficiency = inputFuelRate / maxFuel; // recalculates efficiency

        double fuelLoss = time * fuelLeft * maxFuel;// new variable to determine
                                                    // how much fuel was burned
                                                    // during time period
        fuelLeft = fuelLeft - fuelLoss; // changes the values for fuel left

    }

    public boolean crashed() {
        if (Altitude == 0 && verticalSpeed < -1) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String output = "";
        output += "Eagle: \n";
        output += "Altitude = " + Altitude + "\n";
        output += "Speed = " + verticalSpeed + "\n";
        output += "Fuel = " + fuelLeft + "\n";

        return output;
    }

}