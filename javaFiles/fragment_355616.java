List<SomeType> list = null;
    Map<Object, List<SomeType>> map = new HashMap<Object, List<SomeType>>();
    for (SomeType x : listWithDuplicates) {
        if (map.get(x.getName()) != null) {
            map.get(x.getName()).add(x);
        } else {
            list = new ArrayList<SomeType>();
            list.add(x);
            map.put(x.getName(), list);
        }
    }
    List<SomeType> listWithOutDuplicates = new ArrayList<SomeType>();
    for (Entry<Object, List<SomeType>> entry : map.entrySet()) {
        if (entry.getValue().size() > 1) {
            for (SomeType someType : entry.getValue()) {
                listWithOutDuplicates.add(someType);
            }
        }
    }
    System.out.println(listWithOutDuplicates);
}