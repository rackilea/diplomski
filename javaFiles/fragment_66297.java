public static void main(String[] args) {
    TreeMap<String, Object> map = new TreeMap<String, Object>();

    map.put("com","1");
    map.put("com.aa","2");
    map.put("com.aa.bb","3");

    System.out.println(map.get("com"));
    System.out.println(map.tailMap("com").values()); // ["1","2","3"]

    System.out.println(map.get("com.aa")); //return ["2","3"]
    System.out.println(map.tailMap("com.aa").values());
}