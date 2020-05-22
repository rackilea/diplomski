List<Object[]> values = new ArrayList<>();

// ... some code ...
values.add(new Object[] { "hello", 98 });

// ... some code ...
values.add(new Object[] { "world", 67});

request.batch(DSL.insertInto(
                    DSL.table("MyTable"), DSL.field("MyColumn1"), DSL.field("MyColumn2"))
                 .values((String) null, null))
       .bind(values.toArray(new Object[list.size()][]))
       .execute();