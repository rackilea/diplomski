public List<Person> searchNumber(String name) {
     ArrayList<Person> matchlist = new ArrayList<Person>();
     for (Person prs : person) {
          if(prs.matchesName(name)) {
            matchlist.add(prs);
          }
     }
     return matchlist; 
}