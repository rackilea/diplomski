ArrayList<Persons> persList = new ArrayList<Persons>();
// Populate the list, presumably
List<Persons> extraPeople = new ArrayList<Persons>();

for(Persons p : persList){
    // Note: there's no point in creating a new object only to ignore it...
    Persons pers = service.getPersons(id);
    p.setAddress(pers.getAddress());
    extraPeople.add(pers);
}

persList.addAll(extraPeople);