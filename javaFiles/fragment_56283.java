// Mulit-Line Statement
String[] ppl = new String[]{"Karen (F)", "Kevin (M)", "Lee (M)", "Joan (F)", "Des (M)", "Rick (M)"};
List<String> strings = Arrays.stream(ppl)
        .filter(
                (x) ->
                {
                    return x.contains("(M)");
                }
        ).collect(Collectors.toList());
strings.stream().forEach(System.out::println);