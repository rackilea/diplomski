List<Field<?>> select = getSelect(String fields ...);
SelectQuery<?> query = create.selectQuery();
query.addFrom(table(name("table")));

if(where)
   query.addWhere(Conditions...);
if(groupBy)
   query.addGroupBy(List<Field<?>> ...);
if(orderBy)
   query.addOrderBy(List<Field<?>> ...);