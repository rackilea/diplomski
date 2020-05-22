public static boolean isSorted(Stack s) {

    boolean sorted = true;
    Stack backup = new Stack();

    int prev;
    int curr = Integer.MIN_VALUE;

    while (!s.isEmpty() && sorted) {
        prev = curr;
        curr = s.pop();
        backup.push(curr);
        sorted = (prev <= curr);
    }

    while (!backup.isEmpty()) {
        s.push(backup.pop());
    }

    return sorted;
}