static int countHanoiMoves(int n) {

    if (n == 0) return 0;

    if (n < 0) throw new RuntimeException("What? A negative number of rings?");

    // count(n-1) + 1 + count(n-1)... since we aren't actually moving
    // the rings, but merely counting the number of moves, we can do
    // it a little more cheaply by just multiplying by 2 rather than
    // calling the recursive method twice

    return 2 * countHanoiMoves(n - 1) + 1;
}