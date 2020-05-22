List<Pattern> patterns = Arrays.asList(Pattern.compile("blah"), Pattern.compile("blah2"));
Map<Pattern, String> map = new HashMap<Pattern, String>();
map.put(patterns.get(0), "1");
map.put(patterns.get(1), "2");

System.out.println(map.containsKey(patterns.get(0)));