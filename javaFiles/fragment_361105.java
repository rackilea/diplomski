List<String> strings = Arrays.asList("1", "2", "3");
List<Integer> integers =
        Lists.transform(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });