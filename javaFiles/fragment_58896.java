jooq.select(
       PERSON.FIRST_NAME.as("executor.first_name"),
       PERSON.LAST_NAME.as("executor.last_name"),
       PERSON.PERSON_ID.as("executor.person_id"),
       PERSON.USER_NAME.as("executor.user_name"))
    .from(PERSON)
    .where(PERSON.ID.eq(id))
    .fetchOneInto(Person.class);