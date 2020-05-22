int id = Integer.parseInt(jTextField15.getText());
Person updatePerson = new Person(); // default constructor initializes with empty of default values
for (Person person : personList)
{
    if (person.getPersonid() == id)
    {
        updatePerson = person;
        break; // with break: get first found, without break: get last found. 
        // this depends on whether it is possible to have a person show up more than once.
    }
}

jTextField11.setText(updatePerson.getFirstname());
jTextField17.setText(updatePerson.getSurname());
jTextField12.setText(updatePerson.getPersontype());
jTextField16.setText(updatePerson.getGender());
jSpinner5.setValue(updatePerson.getDateofbirth());