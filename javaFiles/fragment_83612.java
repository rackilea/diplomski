try
{
    listedPrice = Double.parseDouble(userInput.getText().toString());
}
catch (NumberFormatException e)
{
    // do something if invalid double
}