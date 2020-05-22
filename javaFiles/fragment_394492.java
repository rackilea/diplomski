// Queue<EightPuzzle> queue = new PriorityQueue<EightPuzzle>();
Stack<EightPuzzle> stack = new Stack<EightPuzzle>();

public void solveDepthFirst() {

    while (true) {
        EightPuzzle currentState = stack.pop(); // queue.poll();
        if (currentState.goal()) {
            System.out.println(currentState);
            found = true;// to stop DFS when a solution is found (even if
                            // not
                            // optimal)
            return;
        }

        for (int i = 0; i < 4; ++i) {
            if (found)
                return;

            EightPuzzle e = currentState.move(i);// 0 = up, 1 = down, 2 =
                                                    // left,
                                                    // 3= right

            if (!e.equals(currentState) && i != currentState.getLastMove()
                    && !visitedNodes.contains(e)) {
                stack.push(e); // queue.add(e);
            }
            if (!visitedNodes.contains(currentState.toString())) {
                visitedNodes.add(currentState);
            }
        }
    }
}