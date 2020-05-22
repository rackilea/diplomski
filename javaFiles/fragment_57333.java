//given
ListMultimap<Key, String> multimap = ArrayListMultimap.create(); // note ListMultimap
multimap.put(new Key("D123", 1), "ABC");
multimap.put(new Key("D123", 2), "BCD");
multimap.put(new Key("D123", 1), "XYZ");
multimap.put(new Key("J123", 1), "John");
multimap.put(new Key("J123", 2), "Jane");
multimap.put(new Key("J123", 2), "George");
//when
List<String> values = multimap.get(new Key("D123", 1));
//then
assertThat(values).containsExactly("ABC", "XYZ");