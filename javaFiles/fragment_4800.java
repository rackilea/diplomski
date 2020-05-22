Map<Integer, String> nameMap = new HashMap<>(); //A dummy map with empid and name of emp
public static void main(String[] args) {
    nameMap.put(1,"John");
    nameMap.put(2,"Doe");
    nameMap.put(37,"Neon");
    nameMap.put(14,"Shaun");
    nameMap.put(35,"Jason");
    nameMap.put(0,"NEO");
    Set<String> empSet = nameMap.entrySet()
                        .stream()
                        .filter(x->x.getKey()>7 && x.getValue().startsWith("N"))
                        .map(x->x.getValue())
                        .collect(Collectors.toSet());
    empSet.forEach(System.out::println);
}