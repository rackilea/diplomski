String input = "My name is amit";
Map<String, Long> map = new HashMap<>();
map.put("My",   1121L);
map.put("name", 1122L);
map.put("is",   1123L);
map.put("amit", 1124L);

String output =
    Arrays.stream(input.split(" "))
          .map(s -> String.valueOf(map.get(s)))
          .collect(Collectors.joining());