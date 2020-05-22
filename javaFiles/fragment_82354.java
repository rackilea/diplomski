public static void main(String[] args) {
    Map<String, Object> map = Map.of("id", 0, "name", Map.of("title", "Mr.", "personName", Map.of("firstName", "Boot", "familyName", "Strap")));
    Map<String, String> res = flatten(map, "");
    res.entrySet().forEach(System.out::println);
}

name.title=Mr.
name.personName.familyName=Strap
name.personName.firstName=Boot
id=0