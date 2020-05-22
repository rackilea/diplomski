class UpdateNatureJob extends WorkspaceJob
{
  UpdateNatureJob()
  {
    // Scheduling rule
    setRule(ResourcesPlugin.getWorkspace().getRoot());
  }

  @Override
  public IStatus runInWorkspace(final IProgressMonitor monitor)
  {
    ... your nature update

    return Status.OK_STATUS;
  }
}