public boolean checkForSharedGroups(
                    Map<Person, List<String>> associations, 
                    List<Person> peopleToCheck){
    List<String> groupsThatHaveMembers = new ArrayList<String>();
    for(Person p : peopleToCheck){
        List<String> groups = associations.get(p);
        for(String s : groups){
            if(groupsThatHaveMembers.contains(s)){
                // We've already seen this group, so we can return
                return false;
            } else {
                groupsThatHaveMembers.add(s);
            }
        }
    }
    // If we've made it to this point, nobody shares any groups.
    return true;
}