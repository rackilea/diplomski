public static Person findById(Long id) {
    return Ebean.find(Person.class)
        .fetch("address")
        .where() 
        .eq("id", id)
        .findUnique();
}