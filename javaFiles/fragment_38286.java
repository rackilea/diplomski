Field<String> yearMonth = DSL.field("FORMATDATETIME({0}, 'yyyy-MM')",
                    String.class, LICENZE.CREATION_DATE);

List<Record3<Integer, String, String>> records = 
    create.select(DSL.count().as("num_licenze"), 
                  LICENZE.EDIZIONE, 
                  yearMonth.as("anno_mese")).
    from(LICENZE).
    groupBy(LICENZE.EDIZIONE, yearMonth).
    orderBy(yearMonth).
    fetch();