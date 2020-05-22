String colName = "";

if(column.equals(MatchIn.DESCRIPTION)) {
    colName = "description";
} else if(column.equals(MatchIn.NAME)) {
    colName = "name";
}

Criteria criteria = session.createCriteria(Course.class)

for(String key : keyWords) {
    criteria.add(Restrictions.or(Restrictions.like( colName, "%" + key + "%"));
}

return criteria.list();