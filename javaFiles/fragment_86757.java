static int method1Calls = 0;
static int method2Calls = 0;
static int method3Calls = 0;

static final void method1() {
    System.out.println("method1");
    method1Calls += 1;
}

static final void method2() {
    System.out.println("method2");
    method2Calls += 1;
}

static final void method3() {
    System.out.println("method3");
    method3Calls += 1;
}

Runnable call1 = new Runnable() {

    @Override
    public void run() {
        method1();
    }

};

Runnable call2 = new Runnable() {

    @Override
    public void run() {
        method2();
    }

};

Runnable call3 = new Runnable() {

    @Override
    public void run() {
        method3();
    }

};

public void test() {
    // Put the three objects in a list.
    List<Runnable> methods = Arrays.asList(call1, call2, call3);
    // Call them in proportion.
    int[] proportion = {0, 1, 1, 2, 2};
    Random r = new Random();
    for (int i = 0; i < 100; i++) {
        // Pick one.
        int n = r.nextInt(proportion.length);
        // Run it.
        methods.get(proportion[n]).run();
    }
    System.out.println("method1 called " + method1Calls + " times.");
    System.out.println("method2 called " + method2Calls + " times.");
    System.out.println("method3 called " + method3Calls + " times.");
}