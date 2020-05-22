int id = Integer.parseInt(jTextField15.getText());
Person updatePerson = null;
for (Person person : personList)
{
    if (person.getPersonid() == id)
    {
        updatePerson = person;
        break; // with break: get first found, without break: get last found. 
        // this depends on whether it is possible to have a person show up more than once.
    }
}

if (person == null) {
    jTextField11.setText("");
    jTextField11.setVisible(false); // setting fields to empty, in case logic 
    jTextField17.setText("");       // is using them or if someone
    jTextField17.setVisible(false); // sets visible true before setting text
    jTextField12.setText("");       // as you don't want to output wrong data
    jTextField12.setVisible(false); // even for a flicker of a second
    jTextField16.setText(""); 
    jTextField16.setVisible(false); 
    jSpinner5.setValue(SOME_GLOBAL_DEFAULT_DATE);     // ie. 0 or 1970-01-01 
    jSpinner5.setVisible(false); 
} else {
    jTextField11.setText(updatePerson.getFirstname());
    jTextField17.setText(updatePerson.getSurname());
    jTextField12.setText(updatePerson.getPersontype());
    jTextField16.setText(updatePerson.getGender());
    jSpinner5.setValue(updatePerson.getDateofbirth());
}