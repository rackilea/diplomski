int step = 0;
for (T t : set) {
    reportProgress(step, set.size());

    doSomethingWith(t);
}

private static void reportProgress(int step, int total) {
    if (step%10==0) System.out.println("Step "+step+" of "+total);
}