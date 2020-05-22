context.select(CDR.fields())
        .from("cdr_2017_01 as cdr")
        .where(CDR.FIELD1.eq("somevalue")
            .and(CDR.FIELD2.notEqual("value 2")
            .and(CDR.FIELD2.notEqual("value 3")))
        .fetchInto(Cdr.class);