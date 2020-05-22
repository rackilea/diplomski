public void createPartControl(Composite parent) {

    viewer = new TreeViewer(parent);
    viewer.setLabelProvider(new ViewLabelProvider());
    viewer.setContentProvider(new ViewContentProvider());
    viewer.setInput(rootPerson);
    getSite().setSelectionProvider(viewer);
    viewer.addSelectionChangedListener(new ISelectionChangedListener() {
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            Person p = null;
            if (event.getSelection() instanceof TreeSelection) {
                TreeSelection selection = (TreeSelection) event.getSelection();
                if (selection.getFirstElement() instanceof Person) {
                    p = (Person) selection.getFirstElement();
                }
            }
            if (p==null) {
                return;
            }
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            ISourceProviderService service = (ISourceProviderService) window.getService(ISourceProviderService.class);
            PersonSourceProvider sourceProvider = (PersonSourceProvider) service.getSourceProvider(PersonSourceProvider.PERSON_ID);
            sourceProvider.personChanged(p);
        }
    });
}