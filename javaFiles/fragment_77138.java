InputStreamReader isr = new InputStreamReader(is);
BufferedReader buffReader = new BufferedReader(isr);

Map<String, List<String>> map = buffReader.lines()
            .map(s -> s.split(" "))
            .flatMap(Arrays::stream)
            .map(s -> s.split("(?<=_)", 2))
            .collect(groupingBy(p -> p[0], mapping(p -> p[1], toList())));