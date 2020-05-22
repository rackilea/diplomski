private List<String> personID;

//mark methods publicity with your needing(public, private or protected)
public List<String> getPersonID(){
return this.personID;
}

public void setPersonID(List<String>personId){
this.personId = personId;
}

public static void Test(){
Person p = new Person();

p.setPersonId(new LinkedList<String>()); //you can initialize with LinkedList
p.setPersonId(new ArrayList<String>()); //you can Also initialize with ArrayList

//adding Item to PersonId
p.getPersonId().add("1234567890");