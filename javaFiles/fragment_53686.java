Query query = pm.newQuery(University.class);
query.setFilter("lname >= startNameParam");
query.setFilter("lname < stopNameParam");
query.setOrdering("lname asc");
query.declareParameters("String startNameParam");
query.declareParameters("String stopNameParam");
query.setRange(0, 5);
List<University> results = (List<University>) query.execute(search_value, search_value + "z");