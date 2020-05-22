public final class UpdateTabsAction extends Action
{
    public UpdateTabsAction()
    {
        setText("Update tabs");
        setToolTipText("Parses document and updates tabs to reflect textual changes");
        setImageDescriptor(PlatformUI.getWorkbench()
                                     .getSharedImages()
                                     .getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
        setActionDefinitionId("com.portal.agenda.editors.updatetabs");
    }


    @Override
    public void run()
    {
            ARTEditor artEditor = (ARTEditor)activeEditorPart.getSite().getPage().getActiveEditor();
            artEditor.parseDocument();
            artEditor.updateTabs();
    }
}