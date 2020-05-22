Pattern p = Pattern.compile(";");
    Pattern p2 = Pattern.compile(",");
    Pattern p3 = Pattern.compile("=");

    List<String> list = p.splitAsStream(test)
            .flatMap(p2::splitAsStream)
            .flatMap(p3::splitAsStream)
            .collect(Collectors.toList());

    Map<String, Map<String, String>> result = IntStream.iterate(5, x -> x + 6)
            .limit(list.size() / 6)
            .boxed()
            .collect(Collectors.toMap(
                    list::get,
                    x -> Map.of(
                          list.get(x - 5), 
                          list.get(x - 4), 
                          list.get(x - 3), 
                          list.get(x - 2))));