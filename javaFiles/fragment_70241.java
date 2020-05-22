private EditingDomain domain;

public void setActivePart(IAction action, IWorkbenchPart workbenchPart) {
    if (workbenchPart instanceof IEditingDomainProvider) {
        domain = ((IEditingDomainProvider) workbenchPart).getEditingDomain();
    }
}