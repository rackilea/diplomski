public void waysToClimb(int n) {
  // #1
  if (n == 0) {   
    //base case, makes a new line for the next series of steps 
    System.out.println();
  }
  // #2
  if (n >= 1) {
    //1 step, prints 1 and subtracts 1 from n
    System.out.print("1 ");
    waysToClimb(n - 1);
  }
  // #3
  if (n >= 2) {
    //2 steps, prints 2 and subtracts 2 from n
    System.out.print("2 ");
    waysToClimb(n - 2);
  }
}