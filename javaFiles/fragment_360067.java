public class BuilderExample extends IncrementalProjectBuilder
{
  IProject[] build(int kind, Map args, IProgressMonitor monitor)
        throws CoreException 
  {
     // add your build logic here
     return null;
  }

  protected void startupOnInitialize()
  {
     // add builder init logic here
  }

  protected void clean(IProgressMonitor monitor) 
  {
     // add builder clean logic here
  }