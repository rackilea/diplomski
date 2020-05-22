List<String> list = new ArrayList<String>();
    list.add("A");
    list.add("V");
    list.add("C");
    list.add("M");

    Map<String, Object> map = new HashMap<>();
    map.put("1", list);
    map.put("Roll", 123); 

    List<String> remove = Arrays.asList("V","M");

    map.computeIfPresent("1", (k,v)->{
              if(Objects.nonNull(v) && v instanceof List) {
                  @SuppressWarnings("unchecked")
                  List<String> result = (List<String>) v;
                  result.removeIf(i->remove.contains(i));
                  return  result;
              }
            return v;
    });

    System.out.println(map);    //{1=[A, C], Roll=123}