private static void methodWithAtomicInteger(AtomicInteger i){
    i.incrementAndGet();
}

private static void methodWithIntArray(int[] i){
    i[0]++;
}

public static void main(String[] args){
    AtomicInteger integer = new AtomicInteger(0);
    System.out.println(integer);
    methodWithAtomicInteger(integer);
    System.out.println(integer);

    int[] values = new int[]{0};
    System.out.println(values[0]);
    methodWithIntArray(values);
    System.out.println(values[0]);
}