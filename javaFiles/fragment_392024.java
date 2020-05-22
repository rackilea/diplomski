// check if a map contains required keys and those required keys have values as Collection which are not empty
  Map<String, Object> map = new HashMap<>();
  Map<String, Object> nestedMap1 = new HashMap<String, Object>() {{
    put("state", "UP");
  }};
  map.put("key1", nestedMap1);
  map.put("key2", new HashMap<>());

  List<String> requiredKeys = Arrays.asList("key1");
  System.out.println(map.get("key1"));
  Boolean mapContainsEmptyStuff = requiredKeys.stream().anyMatch(
      key -> isObjectNullOrEmpty(map.get(key))
      );
  assert mapContainsEmptyStuff == false;
  System.out.println(String.format("mapContainsEmptyStuff: '%s': %s", map, mapContainsEmptyStuff));

  requiredKeys = Arrays.asList("key1", "key2");
  mapContainsEmptyStuff = requiredKeys.stream().anyMatch(
      key -> isObjectNullOrEmpty(map.get(key))
      );
  assert mapContainsEmptyStuff == true;
  System.out.println(String.format("mapContainsEmptyStuff: '%s': %s", map, mapContainsEmptyStuff));

  requiredKeys = Arrays.asList("key1");
  HashMap<String, String> map1 = new HashMap<String, String>() {{
    put("key1", "badValue");
  }};
  mapContainsEmptyStuff = requiredKeys.stream().anyMatch(
      key -> isObjectNullOrEmpty(map.get(key))
      );
  assert mapContainsEmptyStuff == true;
  System.out.println(String.format("mapContainsEmptyStuff: '%s': %s", map, mapContainsEmptyStuff));