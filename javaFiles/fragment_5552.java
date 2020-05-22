static int[] mergeSortStacks(int[] A) {
        Stack<int[]> stack = new Stack<int[]>();
        Stack<int[]> stack2 = new Stack<int[]>();

        for (int i = 0; i < A.length; i++)
        {
            stack.push(new int[]{A[i]});
        }
        while (stack.size()>1)
        {
            while (stack.size()>1)
            {

                int[] r = stack.pop();
                int[] l = stack.pop();
                int[] merged=merge(l, r);
                stack2.push(merged);
            }
            while (stack2.size()>1)
            {

                int[] r = stack2.pop();
                int[] l = stack2.pop();
                int[] merged=merge(l, r);
                stack.push(merged);
            }
        }
        return stack.isEmpty() ? stack2.pop() : stack.pop();


    }