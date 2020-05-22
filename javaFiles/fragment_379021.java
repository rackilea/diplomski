public class Percentages {

  public static int visit(String[] likelihoods) {
    int smallestPer = Integer.MAX_VALUE;
    int smallestIndex = 0;

    //Go through each element inside likelihoods
    for (int i = 0; i < likelihoods.length; i++) {

      int likelihood = Integer.parseInt(likelihoods[i]);

      //Store the smallest value by comparing the smallest percentage
      if (likelihood < smallestPer) {
        smallestPer = likelihood;
        smallestIndex = i;
      }
      if (likelihood == 0) {
        return i;
      }
    }

    return smallestIndex;  
  }

    public static void main(String[] args) {
        String[] likelihood = {"1222","1122","1222"};

        System.out.println(visit(likelihood));
    }
}