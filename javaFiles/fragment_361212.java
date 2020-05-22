List<Double> collect;
try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream))) {
    collect = buffer.lines()
            .map(Double::valueOf) // convert each line(String) to a Double or Integer, it depends on the size of your Numbers
            .collect(Collectors.toList());
}