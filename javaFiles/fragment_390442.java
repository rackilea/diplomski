QueryRequest queryRequest =
    QueryRequest
        .newBuilder(
            "CREATE TEMP FUNCTION GetWord() AS ('fire');\n"
                + "SELECT COUNT(DISTINCT corpus) as works_with_fire\n"
                + "FROM `bigquery-public-data.samples.shakespeare`\n"
                + "WHERE word = GetWord();")
        // Use standard SQL syntax for queries.
        // See: https://cloud.google.com/bigquery/sql-reference/
        .setUseLegacySql(false)
        .build();
QueryResponse response = bigquery.query(queryRequest);