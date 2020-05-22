@Override
public void eventLoopIdle(final Display display)
{
  // Called whenever the RCP is idle, you can do other things here
  // but it is very important to call 'display.sleep()'

  display.sleep();
}

@Override
public void eventLoopException(final Throwable exception)
{
  // Add code for unhandled exceptions
}