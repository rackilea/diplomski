public class towers {
  private static class Counter{
     private int counter = 0;
     void increment(){ counter++;}
     int counted() { return counter; }
  }
  // ...
        Counter numberOfMoves= new Counter(num,);
        StackMove(num,numberOfMoves);
        System.out.println("Number of moves: "+ numberOfMoves.counted());
  // ...
    public static void StackMove(int N, Counter numberOfMoves) {
        for (int d = N; d > 0; d--)
            integer[1].push(d);
        PrintStack();
        move(N, 1, 2, 3, numberOfMoves);
    }
    public static void move(int N, int a, int b, int c, Counter numberOfMoves) {
        if (N > 0) {
            move(N - 1, a, c, b, numberOfMoves);
            int d = integer[a].pop();
            integer[c].push(d);
            PrintStack();
            move(N - 1, b, a, c, numberOfMoves);
            numberOfMoves.count();
        }
     }
  // ...