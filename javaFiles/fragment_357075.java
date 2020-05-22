Field<String> field = DSL.field("name", String.class);

String name =
DSL.using(configuration)
   .select(field)
   .from("places")
   .where("iso_code = ?", code)
   .fetchOne(field);