SQLTemplates templates = SQLServer2012Templates.builder().printSchema().build();
Configuration configuration = new Configuration(templates);

QItem mm = new QItem ("mm");
QItemWarehouse mb = new QItemWarehouse("mb");

JtdsDataSource ds = getDataSource();
SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, ds);
List<Tuple> toto = queryFactory.select(mm.mmitno, mm.mmitds)
        .from(mb)
        .join(mb._ItemFk, mm )
        .where(mb.mbwhlo.eq("122"))
        .fetch()