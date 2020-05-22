private boolean changeActive;

public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) 
{
  if (changeActive) {   // Don't do anything if already handling change
    return;
  }

  changeActive = true;

  if (page != null)
    {
        page.hideActionSet("org.eclipse.ui.actionSet.keyBindings");
        page.hideActionSet("org.eclipse.ui.actionSet.openFiles");
    }

  changeActive = false;
}