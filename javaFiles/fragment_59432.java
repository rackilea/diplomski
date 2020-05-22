Partners p = PARTNERS.as("p");
Departure d = DEPARTURE.as("d");

using(configuration)
   .select(choose(sign(year(d.DATE).minus(p.BIRTH_YEAR).minus(5)))
       .when(inline(-1), val("<5"))
       .when(inline( 0), val("5+"))
       .when(inline( 1), val("5+"))
       .otherwise(inline("unknown"))
       .as("age"))
   .from(p)
   .join(d).on(d.ID.eq(p.ID))
   .fetch();