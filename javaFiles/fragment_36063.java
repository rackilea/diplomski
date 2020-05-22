try
{
  blah; // throws the unwanted exception.
}
catch (UnwantedExceptionType exception)
{
  throw new DesiredException(exception);  // option 1.
  // or 
  throw new DesiredException(new info, exception) // option 2.
}