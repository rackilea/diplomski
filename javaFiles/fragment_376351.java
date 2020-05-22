List<String> value = map.get("key");
Set<A> set = null;
if (value != null) {
   set = listOfA.stream()
                .filter(a->value.stream()
                                .anyMatch(s->a.getString().equalsIgnoreCase(s)))
                .collect(Collectors.toSet());
}