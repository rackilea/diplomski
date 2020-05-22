public void add(Integer... newIntegers) {
     add(Arrays.asList(newIntegers));
}

public void add(List<Integer> newIntegers) {
    for (Integer i : newIntegers) {
        integers.add(i);
    }
}