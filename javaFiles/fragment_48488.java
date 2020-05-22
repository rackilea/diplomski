ArrayList<PeopleModel> newList = new ArrayList<PeopleModel>();
newList = smsUtils.getPeopleList();
for(int i=0;i<newList.size();i++){ 
    System.out.println(i);
    listPeople.add(newList.get(i)); // Here's the infinity problem.
}