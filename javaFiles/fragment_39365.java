public String removePerson(ArrayList<Person> arrayList,String name)
{
 for(Person currentPerson:arrayList)
 {
     if(currentPerson.getName().equals(name))
     {
         arrayList.remove(currentPerson);
         return "Removed successfully"
     }
 }
 return "No record found for that person";
}