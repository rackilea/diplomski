public PersonDO findPersonDO(String searchFirst, String searchLast) {
  PersonDO person = personCache.get(getPersonKey(searchFirst, searchLast));
  if (person == null) {
    Match match = findClosestMatch(searchFirst, searchLast);
    // Do something here, based on score.
    person = match.getCandidate();
  }
  return person;
}