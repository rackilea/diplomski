public static List<Object> flattenNonRecursive(List<Object> list) {
    List<Object> result = new ArrayList<>();
    LinkedList<Object> stack = new LinkedList<>(list);
    while (!stack.isEmpty()) {
        Object e = stack.pop();
        if (e instanceof List<?>)
            stack.addAll(0, (List<?>)e);
        else
            result.add(e);
    }
    return result;
}

public static List<Object> list(Object... args) {
    return Arrays.asList(args);
}

public static void main(String[] args) {
    List<Object> list = list(1, 3, 5, list(6, 7), 8, 9, 10, list(11, 13, 15, list(16, 17, list(18, 19))), 20);
    System.out.println("flatten=" + flattenNonRecursive(list));
}