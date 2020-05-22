public static boolean rightWingRecursive(int circle, int[] game) {
    Set<Integer> checkerList = new HashSet<Integer>();
    Deque<Integer> statesToExplore = new LinkedList<>();

    int last = game.length - 1;

    statesToExplore.push(circle);

    while (!statesToExplore.isEmpty()) {
        int circleState = statesToExplore.pop();

        if (circleState == last) { // base case for recursion
            return true;
        }

        if (circleState < 0) { // if we go out of bounds on the left
            continue;
        }

        if (circleState > last) { // if we go out of bounds on the right
            continue;
        }

        if (checkerList.contains(circle)) { // check for the impossible case
            continue;
        }

        checkerList.add(circle); // adds the circle value for the last check to
        // checkerList so we can check for the
        // impossible case
        int moveRight = circle + game[circle]; // these two integers help the
        // game move according to the
        // value of the int at circle
        int moveLeft = circle - game[circle];
        statesToExplore.push(moveRight);
        statesToExplore.push(moveLeft);
    }

    return false;
}