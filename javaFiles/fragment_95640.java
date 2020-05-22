public static int searching(int[]init, int[] goal, int[][] grid, int[][] delta, int cost) {
    int r = init[0];
    int c = init[1];

    int[][] closed = new int[5][6];
    closed[r][c] = 1;

    Stack<int[]> st = new Stack<>();
    st.add(new int[] {r, c});

    int costsum = 0;

    int[] temp = new int[] {r, c};
    while(r!=goal[0] || c!=goal[1]) {
        temp = get_next_rc(r, c, grid, delta, closed);
        if(temp != null) {
            r = temp[0];
            c = temp[1];
            costsum = costsum + cost;
            closed[r][c] = 1;
            st.add(new int[] {r, c});
        }
        else {
            // hit a blockade, backtrack steps
            boolean foundnextopen = false;
            while(foundnextopen != true && st.size() > 0) {
                temp = st.pop();
                r = temp[0];
                c = temp[1];
                costsum = costsum - cost;
                temp = get_next_rc(r, c, grid, delta, closed);
                if(temp != null) {
                    st.add(new int[] {r, c}); // add the stack entry back, as it is in path...
                    costsum = costsum + cost; // also add back the cost, as it is in path
                    foundnextopen = true;
                    r = temp[0];
                    c = temp[1];
                    costsum = costsum + cost;
                    closed[r][c] = 1;
                    st.add(new int[] {r, c});
                }
            }
            if(st.size() == 0) {
                // backtracked to initial, no path possible
                return -1;
            }
        }           
    }
    // print nodes
    System.out.println("nodes visited in reverse order:");
    while(st.size() > 0) {
        int[] rc = st.pop();
        System.out.println("visit " + String.valueOf(rc[0]) + ", "+ String.valueOf(rc[1]));
    }
    return costsum;
}

public static int[] get_next_rc(int r, int c, int[][] grid, int[][] delta, int[][] closed) {
    int nextr = r;
    int nextc = c;

    for(int i=0; i<delta.length; i++) {
        nextr = r + delta[i][0];
        nextc = c + delta[i][1];
        if(nextr >=0 && nextc >=0 && nextr < grid.length && nextc < grid[0].length) {
            // not out of bounds
            if(grid[nextr][nextc] != 1) {
                // not a obstacle
                if(closed[nextr][nextc] != 1) {
                    // not visited already
                    return new int[] {nextr, nextc};
                }
            }
        }
    }
    return null;
}