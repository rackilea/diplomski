Function<String, Character> firstChar =  s -> Character.toLowerCase(s.charAt(0));

List<String> a = Arrays.asList("foo", "Abc", "bar", "baz", "aBc");
Map<Character, List<String>> collect = a.stream()
        .collect(Collectors.groupingBy(firstChar));

System.out.println(collect);