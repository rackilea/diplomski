import java.util.*;
public class Mouse extends AbstractCritter {
  private static final int[] allDirections = { NORTH, SOUTH, EAST, WEST };
  private static final Random myRand = new Random();

  private final int myTarget = 16;
  private int myCount = 0;
  private int firstDirection;
  private int secondDirection;

  public Mouse() {
    super('M');
    randomizeDirection();
  }

  public int getMove(CritterInfo info)
  { 
    myCount++;
    if(myCount == myTarget) {
      randomizeDirection();
      myCount = 0;
    }
    return myCount % 2 == 0 ? firstDirection : secondDirection;
  }

  private void randomizeDirection() {
    int index = myRand.nextInt(4);
    firstDirection = allDirections[index];
    int offset = 2 - ((index / 2) * 2); // this turns 0, 1 -> 2; 2, 3 -> 0
    secondDirection = allDirections[offset + myRand.nextInt(2)];
  } 
}