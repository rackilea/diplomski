public class YourClass {
  public static Solution doYourStuff(double startingTemperature, int numberOfIterations, double coolingRate) {
    double t = startingTemperature;
    Solution x = createRandomSolution();
    double ti = t;

    for (int i = 0; i < numberOfIterations; i ++) {
      double f = calculateFitness(x);
      Solution mutatedX = mutate(x);
      double newF = calculateFitness(mutatedX);
      if (newF < f) {
        double p = PR(); // no idea what you're talking about here
        if (p > UR(0, 1)) { // likewise
          // then do nothing
        } else {
          x = mutatedX;
        }
        ti = t * coolingRate;
      }
    }
    return x;
  }

  static class Solution {
    // no idea what's in here...
  }
}