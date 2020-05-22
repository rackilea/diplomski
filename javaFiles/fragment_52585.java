List<Integer> elements = new ArrayList<>(Arrays.asList(1,2,5,4,7,6,4,7,6,4,7));
Set<Integer> tempAccumulator = new LinkedHashSet<>();
Set<Integer> resultSet = new LinkedHashSet<>();
for (Integer number : elements) {
     if(!tempAccumulator.add(number))
        resultSet.add(number);
}