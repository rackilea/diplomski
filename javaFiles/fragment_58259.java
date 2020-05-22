request.batch(DSL.insertInto(
                    DSL.table("MyTable"), DSL.field("MyColumn1"), DSL.field("MyColumn2"))
                 .values((String) null, null))
       .bind("hello", 98)
       .bind("world", 67)
       .execute();