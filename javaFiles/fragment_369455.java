getContext()
    .insertInto(PERSON_DEACTIVATED)
    .columns(PERSON_DEACTIVATED.fields())
    .select(
        select(Arrays
           .stream(PERSON_DEACTIVATED.fields())
           .map(f -> f.equals(PERSON_DEACTIVATED.DEACTIVATED_ON)
                   ? currentTimestamp()
                   : PERSON.field(f))
           .collect(Collectors.toList()))
       .from(PERSON)
       .where(PERSON.ID.eq(id))
    )
    .execute();