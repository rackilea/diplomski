List<Person> listA = new ArrayList<>();
List<Person> listB = new ArrayList<>();
// filling the lists omitted
List<Person> mergedList=new ArrayList<>();
mergedList.addAll(listA);
mergedList.removeAll(listB);
mergedList.addAll(listB);