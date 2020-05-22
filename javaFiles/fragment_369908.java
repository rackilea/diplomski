Stack<Integer> stack = new Stack<>(100_000_000L);
System.out.println(Runtime.getRuntime().maxMemory());
for (int j = 0; j < 100; ++j) {
    System.out.println(j + "th run");
    for (int i = 0; i < 10_000_000; ++i) {
        stack.push(i);
    }
    System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    Thread.sleep(10000);
    stack.empty();
    System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    Thread.sleep(10000);
}