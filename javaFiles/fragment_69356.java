public class FindLadder implements Comparator<Ladder>{
  @Override
  public int compare(Ladder lhs, Ladder rhs) {
    if(lhs.length() < rhs.length() && lhs.length() > 12) // Suppose rhs.length() is 15
    {
        return 0;
    }
    if(lhs.length() < 12) {
        return -1;
    }
    else {
        return 1;
    }
  }
}