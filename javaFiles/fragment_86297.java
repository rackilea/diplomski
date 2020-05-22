List<Double> doubles = new ArrayList<>();
Collections.addAll(doubles, 0.0, 1.0, 2.0);

List<String> strings = new ArrayList<>();
Collections.addAll(strings, "X", "Y", "Z");

List<List<?>> lists = new ArrayList<>();
Collections.addAll(lists, strings, doubles);