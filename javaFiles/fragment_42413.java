// First approach: returns list of `raw` rows so it's mpst flexible
    List<SqlRow> rows = Ebean
            .createSqlQuery("SELECT id, count(bar) AS bar_count FROM foo WHERE 1 GROUP BY bar")
            .findList();


    // Second uses `GROUP BY`, returns entities BUT without alias fields
    List<Foo> foos = Ebean
            .createQuery(Foo.class, "WHERE 1 GROUP BY bar")
            .select("id")
            .findList();

    // or just...
    List<Foo> foos2 = Foo
            .find.where("1 GROUP BY bar")
            .findList();

    // Third, returns entities, alias fields can be mapped to model as well (requires @Transient annotation for these fields in model)
    RawSql rawSql = RawSqlBuilder
            .parse("SELECT id, count(bar) FROM foo WHERE 1 GROUP BY bar")
            .columnMapping("id", "id")
            .columnMapping("count(bar)", "bar_count")
            .create();

    com.avaje.ebean.Query<Foo> query = Ebean.find(Foo.class);
    query.setRawSql(rawSql);

    List<Foo> foosRaw = query.findList();