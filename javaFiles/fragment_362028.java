IProject project = getProjectForPreferences( projectPreferences );
ISchedulingRule rule = project.getWorkspace().getRuleFactory().modifyRule( project );
Job job = new Job( "Access Project Preferences" ) {
  @Override
  protected IStatus run( IProgressMonitor monitor ) {
    if( project.exists() ) {
      // read or write project preferences
    }
    return Status.OK_STATUS;
  }
};
job.setRule( rule );
job.schedule();