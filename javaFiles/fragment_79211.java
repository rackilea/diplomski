for (int i=0; i<list.size(); i++) {
    if (i%10==0) System.out.println("Step "+i+" of "+list.size());

    T t = list.get(i);
    doSomethingWith(t);
}