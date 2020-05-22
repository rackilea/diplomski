IWorkspace workspace = ResourcesPlugin.getWorkspace();
   IResourceChangeListener listener = new IResourceChangeListener() {
      public void resourceChanged(IResourceChangeEvent event) {
         System.out.println("Something changed!");
      }
   };
   workspace.addResourceChangeListener(listener);