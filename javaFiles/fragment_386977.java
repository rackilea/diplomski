public class Point {
  int i;
  int j;
  char value;
  Point parent;
  ArrayList<Point> children;

  public static final maze[][];

  public Point(int i, int j, char val) {
    this.i = i;
    this.j = j;
    this.val = val
    parent = null;
    children = new ArrayList<Point>();
  }

  public void generateChildren() {
    if (i + 1 <= mazeHeight && j + 1 <= mazeWidth) {
      if (maze[i+1][j+1] == 'O') {
        if (!maze[i+1][j+1].equals[this.parent]) {
          Point child = new Child(i+1, j+1, 'O');
          child.parent = this;
          children.add(child);
        }
      }
    }
    // ADD LOGIC FOR OTHER CASES i -1 j -1 etc ...  
  }
}