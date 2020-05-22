PlatformUI.getWorkbench().getDisplay().asyncExec(
            new Runnable() {
              public void run() {
                try {
                  myView view =null;
                  view = (myView)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("pluginProject.myView");
                  view.reloadMyFrame();
                } catch (CoreException e) {
                  e.printStackTrace();
                } 
              }
            });