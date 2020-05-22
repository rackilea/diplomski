import java.util.Random;

public class Defender {

    public double getDEFtype() {

        double genPercent = new Random().nextDouble();

        if ( genPercent <= 1d/3d ) {
            System.out.println("Defense: low");
            return 0; // low type
        }
        else if ( genPercent <= 2d/3d ) {
            System.out.println("Defense: medium");
            return 1; // medium type
        }
        else {
            System.out.println("Defense: high");
            return 2; // high type
        }
    }
}