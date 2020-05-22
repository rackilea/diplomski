query = new Query(new Criteria().andOperator(
        Criteria.where("_id").is(myClassId),
        Criteria.where("contacts.collection.value").is("2"),
        Criteria.where("contacts.collection._class").is("SubClass2"));
        update.set("contacts.0.collection.$.value", "3");
        mongoTemplate.updateFirst(query, update, MyClass.class);