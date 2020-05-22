public void SpecificationEditPart.handleNotification(Notification event)
{

    EObject eObject = (EObject)event.getNotifier();

    SpecificationImpl notifier = (SpecificationImpl)eObject;

    EList<Satisfy> satisfyRelationList = notifier.getIncoming();

    int satisfyRelationListSize = satisfyRelationList.size();

    TransactionalEditingDomain ted = (TransactionalEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(eObject);

    try
    {
        ted.runExclusive(new Runnable()
        {
            public void run ()
            {
                Display display = PlatformUI.getWorkbench().getDisplay();
                display.asyncExec(new Runnable()
                {
                    public void run ()
                    {
                        ted.getCommandStack().execute(new SetCommand(this.ted, notifier, xxxPackage.Literals.SPECIFICATION__MAPPED, true));
                    }
                });
            }
        });
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
}