int step = 0;
for (T t : set) {
    if (step%10==0) System.out.println("Step "+step+" of "+set.size());

    doSomethingWith(t);
}