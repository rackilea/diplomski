String input = "\"mode1\":2,\"mode2\":3,\"mode3\":7";
Map<String, Integer> map = Stream.of(input.split(","))
            .map(it -> it.split(":"))
            .collect(Collectors.toMap(
                it -> it[0].replace("\"", ""),
                it -> Integer.parseInt(it[1])));