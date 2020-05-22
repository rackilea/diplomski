public static void main(String[] args) {

    List<List<String>> list = new ArrayList<>();
    list.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
    list.add(new ArrayList<>(Arrays.asList("1", null, "3")));
    list.add(new ArrayList<>(Arrays.asList("12", "34", null)));

    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < list.get(0).size(); i++) {
        List<String> value = new ArrayList<>();
        for (int j = 1; j < list.get(0).size(); j++) {
            value.add(list.get(j).get(i));
        }
        map.put(list.get(0).get(i), value);
    }       

    System.out.println(map.toString()); // {a=[1, 12], b=[null, 34], c=[3, null]}
}