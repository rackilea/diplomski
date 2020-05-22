ResultQuery resultQuery = context.resultQuery(
        sqlTemp,
        DSL.param("bizdate", "20190801"),
        DSL.field(sortField).sort(sortOrder),
        DSL.param("limit", limitOffset),
        DSL.param("rows", limitRows));