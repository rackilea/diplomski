Map<String, PersonDO> personCache = Maps.newHashMap();

public String getPersonKey(String first, String last) {
  return first + " " + last;
}

...
// Initialization code
for(PersonDO p: dao.getPeople()) {
    personCache.put(getPersonKey(p.getFirstName(), p.getLastName()), p);
}