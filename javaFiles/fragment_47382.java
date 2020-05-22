String str = "result = aaa + bbb + aa + ccc";
List<String> list = Arrays.asList("aaa", "ccc", "aa", "bbb");

Map<String, Integer> wordStart = Pattern.compile("\\w+").matcher(str).results()
        .collect(Collectors.toMap(MatchResult::group, MatchResult::start));
list.sort(Comparator.comparing(wordStart::get));

System.out.println(list);