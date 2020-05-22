try
{
    SimpleDateFormat fDate = new SimpleDateFormat("dd-MM-yyyy");
    fDate.setLenient(false);
    Date dateValue = fDate.parse(dateText);
    Main.flightObjects[Main.flightCount].setFlightDate(dateValue);
}
catch(java.text.ParseException d)
{
    JOptionPane.showMessageDialog(null,
    "Please make sure your date is in the correct format! dd-mm-yyyy\n e.g. 16-03-2013",
    "Date Error 1",1);
}