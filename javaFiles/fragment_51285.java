public void upsertMongoContact(List<Person> persons) {

    for (Person person : persons) {
        for (MyContacts contact : person.getContact().getmyContacts()) {
            Query sQuery = new Query();
            Criteria sCriteria = Criteria.where("firstName").is((person.firstName()));
            sCriteria.and("contact.myContacts.name").is(contact.name());
            sQuery.addCriteria(sCriteria);
            Update sUpdate = new Update();
            sUpdate.set("contact.myContacts.$.phone", person.phone());
            UpdateResult sUpdateResult = mongoOps.updateFirst(sQuery, sUpdate, Person.class);
            if (sUpdateResult.getModifiedCount() == 0) {
                Query pQuery = new Query();
                Criteria pCriteria = Criteria.where("firstName").is((person.firstName()));
                pQuery.addCriteria(pCriteria);
                Update pUpdate = new Update();
                pUpdate.push("contact.myContacts", contact);
                mongoOps.updateFirst(pQuery, pUpdate, Person.class);
            }
        }
    }
}