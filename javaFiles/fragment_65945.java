SQLQuery query = session.createSQLQuery(
    "SELECT * FROM tableA a
    INNER JOIN 
    (SELECT fieldA, sum(fieldB) as sum from tableB) b
    ON a.fieldA = b.fieldA and a.fieldC = b.sum"
);