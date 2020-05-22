private void initKeyBindingContext()
{
    final IContextService cService = (IContextService)getSite().getService(IContextService.class);
    textEditor.getTextViewer().getTextWidget().addFocusListener(new FocusListener()
    {
        IContextActivation currentContext = null;


        public void focusGained(FocusEvent e)
        {
            if (currentContext == null)
                currentContext = cService.activateContext("com.portal.agenda.editors.context");
        }


        public void focusLost(FocusEvent e)
        {
            if (currentContext != null)
            {
                cService.deactivateContext(currentContext);
                currentContext = null;
            }
        }
    });
}