@End(FlushMode=MANUAL) //yes syntax is wrong, but you get the point
public String saveOrganization() {
//Inside some save method, and organization contains some data that user has filled through a form, or chosen from combobox

org.setPerson(person); //Yes this is only demonstration and should have been collection (OneToMany)
//Do some constraint or validation check
entityManager.save(org);
//Simulate saving org
//if everything went ok
entityManager.flush() //Now person and organization is finally stored in the database
return "success";
}