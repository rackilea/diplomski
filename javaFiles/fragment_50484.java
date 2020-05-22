//In case multiple persons match :)
List<String> result = new LinkedList<String>();

for (People person : peopleList) {
  if (person.getName().equals(name) && person.getPostcode().equals(postCode))
    result.add(person.getId()); 
}

if(result.isEmpty()){
  return null;
}else{
  return result;
}