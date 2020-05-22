sc.cassandraTable("test", "person")
    .where("age > ?", "15")
    .where("age < ?", "20")
    .keyBy(new Function<Person, String>() {
                public String call(Person _person) throws Exception {
                    return _person.getPersonid();
                }
            });