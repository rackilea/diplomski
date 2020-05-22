public static void main(String[] args) {
    ArrayDeque<String> x = new ArrayDeque<>();
    x.add("foo");
    solve(x, Deque::pollFirst); // first case
    PriorityQueue<String> x1 = new PriorityQueue<>();
    x1.add("bar");
    solve(x1, Queue::poll); // second case
}

public static <T extends Queue> void solve(T x, Function<T, String> fun) {
    String res = fun.apply(x);
    System.out.println(res);
}