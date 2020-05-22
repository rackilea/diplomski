public void changeTitle()
{
    String year = cyear.getSeletedItem().toString();
    String month = cmonth.getSelectedItem().toString();
    String day = cday.getSelectedItem().toString();

    setTitle("Today is "+ day + "of "+ month + "of " + year);      
}