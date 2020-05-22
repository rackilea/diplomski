import java.util.Arrays;
import java.util.Vector;

class Main {
  class Coords {
    int x;
    int y;
    Coords(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  int [][] array = { {3,5,1},{6,7,4},{8,2,9}};
  Vector<Coords> getNeighbors(Coords coords) {
     int x = coords.x;
     int y = coords.y;
     Vector<Coords> result = new Vector<Coords>();
     if (x < array.length - 1) {
        if (array[x + 1][y] >= array[x][y])
          result.add(new Coords(x + 1, y));
     }
     if (x > 0) {
        if (array[x - 1][y] >= array[x][y])
          result.add(new Coords(x - 1, y));
     }
     if (y < array[x].length - 1) {
        if (array[x][y + 1] >= array[x][y])
          result.add(new Coords(x, y + 1));
     }
     if (y > 0) {
        if (array[x][y - 1] >= array[x][y])
          result.add(new Coords(x, y - 1));
     }
     if (x < (array.length - 1 ) &&  (y < array[x].length - 1)) {
        if (array[x + 1][y + 1] >= array[x][y])
          result.add(new Coords(x + 1, y + 1));
     }
     if (x < (array.length - 1 ) &&  (y > 0)) {
        if (array[x + 1][y - 1] >= array[x][y])
          result.add(new Coords(x + 1, y - 1));
     }
     if (x > 0 &&  (y < array[x].length - 1)) {
        if (array[x - 1][y + 1] >= array[x][y])
          result.add(new Coords(x - 1, y + 1));
     }
     if (x > 0 &&  y > 0) {
        if (array[x -1][y - 1] >= array[x][y])
          result.add(new Coords(x - 1, y - 1));
     }
     return result;
  }
  void checkNode(Vector<Integer> path, Coords coords) {
    path.add(array[coords.x][coords.y]);
    Vector<Coords> neighbors = getNeighbors(coords);
    if (neighbors.size() == 0) {
       for (Integer i : path) {
         System.out.print(i+"\t");
       }
       System.out.println();
    }
    for (Coords c : neighbors) {
      Vector<Integer> newpath = (Vector<Integer>) path.clone();
      checkNode(newpath, c);
    }
  }
  Main() {
    System.out.println ("Array: " + Arrays.deepToString(array));
    checkNode(new Vector<Integer>(),new Coords(0,0));
  }

  public static void main(String args[]) {
    new Main();
  }
}