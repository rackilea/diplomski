@Override
public Object onRetainNonConfigurationInstance() 
{
  if (myObject != null) // Check that the object exists
      return(myObject);
  return super.onRetainNonConfigurationInstance();
}