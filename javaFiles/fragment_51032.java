List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
Spliterator<Integer> s1 = list.spliterator();
Spliterator<Integer> s2 = s1.trySplit();
list.add(11);
list.add(12);
Spliterator<Integer> s3 = s2.trySplit();
try {            
    s1.forEachRemaining(s -> System.out.println("1 " + s));
} catch(Exception ex) {
    System.out.println("1 "+ex);
}
try {            
    s2.forEachRemaining(s -> System.out.println("2 " + s));
} catch(Exception ex) {
    System.out.println("2 "+ex);
}
try {            
    s3.forEachRemaining(s -> System.out.println("3 " + s));
} catch(Exception ex) {
    System.out.println("3 "+ex);
}