private class LocationChange implements LocationListener
{    
  @Override
  public void changing(final LocationEvent event)
  {
    // You can use 'event.doit = false' to stop the change here
  }

  @Override
  public void changed(final LocationEvent event)
  {
    // Record the change
  }
}