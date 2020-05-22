Map<Integer, BiFunction<Person,String,String>> map = 
        new HashMap<Integer, BiFunction<Person,String,String>>();  
static {
    map.put(1, (person, str)->person.setLastName(str));

}