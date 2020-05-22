TextCriteria criteria = TextCriteria.forDefaultLanguage()
  .matching("Food");
Query query = TextQuery.queryText(criteria)
  .sortByScore();

List<Event> events = template.find(query, Event.class);