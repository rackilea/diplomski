void it(Iterator i) {
    if (i.hasNext()) {
        System.out.println(i.next());
        it(i);
    }
}