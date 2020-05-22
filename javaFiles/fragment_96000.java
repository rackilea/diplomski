List<Double> list = new ArrayList<>();
while (scanner.hasNextDouble()) {
    list.add(scanner.nextDouble());
}
//if you want to work with array
Double[] array = new Double[list.size()];
array = list.toArray(array);