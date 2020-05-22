string dateStr = "19/05/2013";
DateTime date;
if (DateTime.TryParseExact(dateStr, "dd/MM/yyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, out date))
{
    // successfully parsed the string into a DateTime instance =>
    // here we could add the desired number of months to it and construct
    // a new DateTime
    DateTime newDate = date.AddMonths(14);
}
else
{
    // parsing failed => the specified string was not in the correct format
    // you could inform the user about that here
}