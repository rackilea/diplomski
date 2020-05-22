@Override
public Object start(final IApplicationContext context) throws Exception
{
  String [] args = (String [])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);

  // TODO scan args for an option telling you which start is required

  // TODO If GUI required call PlatformUI.createAndRunWorkbench in the usual way
  // TODO otherwise do console app
}