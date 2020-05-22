public class RandomWalkers {

public static void main(String[] args) {
    int r = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    int x = 0;
    int xx = 0;
    int y = 0;
    int yy = 0;
    int numSteps = 0;
    int totalNumSteps = 0;
    double randNum = 0.0;
    double avgSteps = 0.0;

    for (long i = 0; i < trials; i++) {
        x = 0;
        xx = 0;
        y = 0;
        yy = 0;
        numSteps = 0;
        while (Math.abs(x - xx) + Math.abs(y - yy) != r) {
            randNum = Math.random();
            if (randNum <= .25) {
                // North
                yy++;

            } else if (randNum <= .5) {
                // East
                xx++;

            } else if (randNum <= .75) {
                // South
                yy--;

            } else {
                // West
                xx--;

            }
            numSteps++;
        }
        totalNumSteps += numSteps;
    }

    avgSteps = totalNumSteps / (1.0 * trials);
    System.out.println("average number of steps = " + avgSteps);


   }

}