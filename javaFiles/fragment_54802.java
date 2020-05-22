final Map<String, List<String>> eventsToCompetitors;
final List<String> allCompetitors;

eventsToCompetitors = ...

allCompetitors = new ArrayList<String>();
for (Collection<String> competitors : eventsToCompetitors.values())
{
  allCompetitors.addAll(competitors);
}