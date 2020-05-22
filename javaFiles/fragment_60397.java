UIJob job = new UIJob("set size")
   {
     @Override
     public IStatus runInUIThread(IProgressMonitor monitor)
     {
       window.setWidth(800);

       return Status.OK_STATUS;
     }
  };

job.schedule(2000);