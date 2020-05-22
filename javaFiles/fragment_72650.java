public static List<String> process(List<Data> data) {
    return data.stream()
               .map(d -> Arrays.stream(Enum.values()).map(d::get).collect(Collectors.toList()))
         //    .map(d -> Arrays.stream(Enum.values()).map(e -> d.get(e.name())).collect(Collectors.toList()))
               .flatMap(List::stream)
               .collect(Collectors.toList());
}