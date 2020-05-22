public static int countGroupsLinear(int[] a) {
    Stack<Integer> stack = new Stack<>();
    stack.push(a[0]);
    for (int i = 1; i < a.length; i++) {
        if (a[i] >= stack.peek()) stack.push(a[i]);
        else {
            int last = stack.pop();
            while (stack.size() > 0 && a[i] < stack.peek()) stack.pop();
            stack.push(last);
        }
    }
    return stack.size();
}