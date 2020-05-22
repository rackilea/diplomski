QueryBuilder<Foo, String> qb = dao.queryBuilder();
Where<Foo, String> where = qb.where();
where.eq(Foo.VAL_COLUMN_NAME, foo1.val)
        .and()
        .eq(Foo.STRING_COLUMN_NAME, foo1.stringField)
        .or()
        .eq(Foo.STRING_COLUMN_NAME, foo2.stringField);