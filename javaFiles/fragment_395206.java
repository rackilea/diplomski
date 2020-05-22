SQLQuery query = new SQLQueryImpl(connection, dialect); 
query.from(myTable);

BooleanBuilder wheres = new BooleanBuilder();

if(notBlank(searchCriteria1))
   wheres.and(myTable.column1.eq(searchCriteria1));
if(notBlank(searchCriteria2))
   wheres.and(myTable.column2.eq(searchCriteria2));
if(notBlank(searchCriteria4) && notBlank(searchCriteria5))
   wheres.andAllOf(myTable.date.goe(searchCriteria4),  myTable.date.loe(searchCriteria5));  //you may want to use myTable.date.between(...)

if (...) {
   query.orderBy(myTable.column1.asc());
} else if (...){
   query.orderBy(myTable.column2.asc());
}

query.limit(100); //it is good to limit a result
query.list(myTable.all());