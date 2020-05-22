private static long withModulus(int[] arr) {
    long elapsedTime = System.nanoTime();
    for(int i = 0; i < arr.length; i++) {
        List list;
        if ((i % 2) == 0) {
            list = new ArrayList<>();
            list.add(new Object());
        } else {
            list = new LinkedList<>();
            list.add(new Object());
        }
    }
    return (System.nanoTime() - elapsedTime);
}

private static long withFlag(int[] arr) {
    long elapsedTime = System.nanoTime();
    for(int i = 0; i < arr.length; i++) {
        List list;
        boolean flag = true;
        if (flag) {
            list = new ArrayList<>();
            list.add(new Object());
            flag = false;
        } else {
            list = new LinkedList<>();
            list.add(new Object());
            flag = true;
        }
    }
    return (System.nanoTime() - elapsedTime);
}

private static long withAnd(int[] arr) {
    long elapsedTime = System.nanoTime();
    for(int i = 0; i < arr.length; i++) {
        List list;
        if ((i & 1) == 1) {
            list = new ArrayList<>();
            list.add(new Object());
        } else {
            list = new LinkedList<>();
            list.add(new Object());
        }
    }
    return (System.nanoTime() - elapsedTime);
}

private static long withTwoLoops(int[] arr) {
    long elapsedTime = System.nanoTime();
    for(int i = 0; i < arr.length; i+=2) {
        List list;
        list = new ArrayList<>();
        list.add(new Object());
    }
    for(int i = 1; i < arr.length; i+=2) {
        List list;
        list = new LinkedList<>();
        list.add(new Object());
    }
    return (System.nanoTime() - elapsedTime);
}