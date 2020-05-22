int i = 0; // some default
try
{
   i = Integer.parseInt(number);
}
catch (NumberFormatException nfe)
{
   // Good practice to log this, but the default int is fine.
}