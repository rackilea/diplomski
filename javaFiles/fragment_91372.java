DateDialog dateStart = new DateDialog(startDate, mYear, mMonth,mDay);
dateStart.setDateListener( new DateDialogListener()
{
     public void dialogDateChanged()
     {
         checkdates(); 
     }     
});