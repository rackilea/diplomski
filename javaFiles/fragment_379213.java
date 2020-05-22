Random randomNumGenerator = new Random();
Set<Map.Entry<Integer, Integer>> generated = new LinkedHashSet<>();
while (generated.size() < 20) {
    int randomRows = randomNumGenerator.nextInt(6);
    int randomColumns = randomNumGenerator.nextInt(8);
    generated.add(new AbstractMap.SimpleEntry<>(randomRows,randomColumns));
}
System.out.println(generated);