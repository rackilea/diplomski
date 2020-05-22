String name =
DSL.using(configuration)
   .select(PLACES.NAME)
   .from(PLACES)
   .where(PLACES.ISO_CODE.eq(code))
   .fetchOne(PLACES.NAME);