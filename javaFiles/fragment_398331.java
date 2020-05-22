BasicDBObject updateFields = new BasicDBObject();
updateFields.append("birth_year", birth_year);
updateFields.append("country", country);
BasicDBObject setQuery = new BasicDBObject();
setQuery.append("$set", updateFields);
col.update(searchQuery, setQuery);