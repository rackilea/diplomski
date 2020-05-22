public int solution(int[] H) {

        Stack<Integer> stack = new Stack<>();

        stack.push(H[0]);
        int count = 1;

        int N = H.length;

        for (int i = 1; i < N; i++) {

            if (H[i] == stack.peek()) {
                continue;
            } else if (H[i] > stack.peek()) {
                stack.push(H[i]);
                count++;
            } else {

                while (!stack.isEmpty() && H[i] < stack.peek()) {
                    stack.pop();
                }

                /*
                 * the new entity is either in same elevation or higher
                 * */

                /*
                * if in same elevation, we already added the block, so keep iterating
                * */
                if (!stack.isEmpty() && H[i] == stack.peek()) {
                    continue;
                }

                stack.push(H[i]);
                count++;
            }
        }

        return count;
    }