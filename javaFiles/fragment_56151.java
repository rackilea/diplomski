// This is how you can select REGION.*
dsl.select(REGION.fields())

// This is how you can add more fields to the SELECT clause
   .select(

// Nested selects are just select() as well (from DSL)
        select(count())
       .from(CITY)
       .where(CITY.REGION_ID.eq(REGION.ID))

// This is how you convert an org.jooq.Select into a Field
       .asField("num")
   )
   .from(REGION)
   .fetch();