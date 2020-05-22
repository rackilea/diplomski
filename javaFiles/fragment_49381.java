import java.util.Random;

public class Attacker {

    public double low = 0;

    public void setLow(double low) {
        this.low = low;
    }

    public double getATKtype() {

        double genPercent = new Random().nextDouble() * 100.0;

        System.out.println(low);
        if ( genPercent <= low ) {
            System.out.println("Attack: low");
            return 0; // low type
        }
        else if ( genPercent <= 1 + low ) { // genPercent <= medium + low
            System.out.println("Attack: medium");
                return 1; // medium type
        }
        else {
            System.out.println("Attack: high");
            return 2; // high type
        }
    }
}