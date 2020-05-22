public void testAddRemove() throws Exception
{
    //it runs it 1000 times
    addRemove(1000);
}

public void addRemove(int NUMBER_OF_TIMES) throws Exception
{
for(int i=0; i<NUMBER_OF_TIMES; i++){
    solo.assertCurrentActivity("Check on first activity", MainActivity.class);
    solo.clickOnActionBarItem(R.id.action_addperson);
    solo.enterText(0, "id number");
    solo.enterText(1, "Name");
    solo.enterText(2, "Last Name");
    solo.enterText(3, "Address");
    solo.enterText(4, "Contact number");
    solo.enterText(5, "Code");
    solo.enterText(6, "Date");
    solo.clickOnMenuItem("Save Note");
}
}