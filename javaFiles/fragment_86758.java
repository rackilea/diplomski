public void testShuffle() {
    System.out.println("Using shuffle");
    // Put the three objects in a list.
    List<Runnable> methods = new ArrayList<>();
    // Call them in proportion
    Runnable[] runners = {call1, call2, call3};
    int[] proportion = {10, 20, 20};
    // Grow my list.
    for (int i = 0; i < proportion.length; i++) {
        for (int j = 0; j < proportion[i]; j++) {
            methods.add(runners[i]);
        }
    }
    // Shuffle it.
    Collections.shuffle(methods);
    // Call them.
    for (Runnable r : methods) {
        r.run();
    }
    System.out.println("method1 called " + method1Calls + " times.");
    System.out.println("method2 called " + method2Calls + " times.");
    System.out.println("method3 called " + method3Calls + " times.");
}