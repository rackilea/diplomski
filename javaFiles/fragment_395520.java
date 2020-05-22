public Person lookup(String name){
    Person target = null;
    for (target = firstPerson; target != null; target = target.nextPerson) { 
         if (name.equals(target.name)) {
              return target;
         }
    }
    return target; // Or null explicitly - matter of taste.
}