public List<Pig> pigSquadron(boolean pigsMightFly) {
   List<Pig> airbornePigs = new ArrayList<Pig>();
   while (...) {
     Pig piggy = new Pig();
     ...
     if (pigsMightFly) {
       airbornePigs.add(piggy);
     }
     ...
   }
   return airbornePigs.size() > 0 ? airbornePigs : null;
 }