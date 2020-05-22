UNWIND {rows} as row
MATCH (n),(m) 
WHERE id(n)=row.nid and id(m)=row.mid
CREATE (n)-[r:MY_REL {
    ID:row.relId,
    TYPE:row.relType,
    PROPERTY_1:row.someData_1,
    PROPERTY_2:row.someData_2,
    .........................
    PROPERTY_14:row.someData_14
}]->(m) 
RETURN id(n),id(m),r