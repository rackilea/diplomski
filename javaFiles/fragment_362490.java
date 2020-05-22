public static void main(String[] args) {
    Object[][] parameters ={ new String[]{"HELLO", "WORLD"},
                             new Integer[]{1,2,3},
                             new Double[]{0.1, 0.9, 5.3}
                            };
    Arrays.stream(parameters).forEachOrdered(p -> doSomething(p));
}

private static void doSomething(Object[] objects) {
    try {
        TimeUnit.SECONDS.sleep(1);

        System.out.println(Arrays.toString(objects));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}