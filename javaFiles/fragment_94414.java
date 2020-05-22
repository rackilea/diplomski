public String searchNumber(String name) {
     for (Person prs : person) {
          if(prs.matchesName(name)) {
            return prs.toString();
          }
     }
     return "number not known"; 
}