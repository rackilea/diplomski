// Insert
person.setDeactivatedOn(new Timestamp(System.currentTimeMillis()));
person.changed(true); // Sets all flags to true
getContext().insertInto(PERSON_DEACTIVATED)
        .set(person)
        .execute();