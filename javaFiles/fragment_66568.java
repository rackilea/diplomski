// Required to avoid multiple registering of the action
private IHandlerActivation iHandlerActivation;

@Override
public void setActivePage(IEditorPart part)
{
    if (part != null && iHandlerActivation == null)
    {
        IHandlerService hService = ((IHandlerService)part.getSite().getService(IHandlerService.class));
        iHandlerActivation = hService.activateHandler(updateTabsAction.getActionDefinitionId(),
                                                      new ActionHandler(updateTabsAction));
    }

    if (activeEditorPart == part)
        return;
    activeEditorPart = part;

    // ...skipped...
}