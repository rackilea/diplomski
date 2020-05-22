private Person person;
private Organization org;

@Begin(join=true,FlushMode=MANUAL) //yes syntax is wrong, but you get the point
public String savePerson() {
//Inside some save method, and person contains some data that user has filled through a form

//Now you want to save person if they have name filled in (yes I know this example should be done from the view, but this is only an example
try {
  if("".equals(person.getName()) {
    StatusMessages.instance().add("User needs name");
    return "error"; //or null
  }
  entityManager.save(person);
  return "success";
} catch(Exception ex) {
  //handle error
  return "failure";
}
}