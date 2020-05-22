public static void main(String[] args) {
    Object[][] parameters ={ new String[]{"HELLO", "WORLD"},
                             new Integer[]{1,2,3},
                             new Double[]{0.1, 0.9, 5.3}
                            };
    for (int i = 0; i < parameters.length; i++) {
        try {
            TimeUnit.SECONDS.sleep(1);

            doSomething(parameters[i]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private static void doSomething(Object[] objects) {
    System.out.println(Arrays.toString(objects));
}