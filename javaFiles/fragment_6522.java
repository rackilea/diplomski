public void createPartControl(Composite aParent) {
        Composite displayArea = new Composite(aParent, SWT.FILL);
        displayArea.setLayout(new GridLayout());
        displayArea.setLayoutData(new GridData(GridData.FILL,GridData.FILL, true, true));
        Composite historyComposite = new Composite(displayArea, SWT.NONE);

        layout = new StackLayout();
        historyComposite.setLayout(layout);
        historyComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL,GridData.VERTICAL_ALIGN_FILL, true, true));
        createEmptyArea(historyComposite);

        super.createPartControl(historyComposite);

        IWorkbenchWindow w = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow();
        ICommandService csrv = (ICommandService) w
                .getService(ICommandService.class);
        Command command = csrv
                .getCommand("org.eclipse.egit.ui.RepositoriesLinkWithSelection"); //$NON-NLS-1$
        reactOnSelection = (Boolean) command.getState(
                RegistryToggleState.STATE_ID).getValue();
//XXX added this code and changed the position of some statement to make it work
        GridDataFactory.fillDefaults().grab(true, true).applyTo(historyComposite);
        filterToolbar = new FilterToolbar(this, displayArea);
        ((GridData) filterToolbar.getLayoutData()).verticalAlignment = SWT.END;
        Point computeSize = filterToolbar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        ((GridData) filterToolbar.getLayoutData()).minimumWidth = computeSize.x;
        ((GridData) filterToolbar.getLayoutData()).minimumHeight = computeSize.y;
        GridDataFactory.fillDefaults().grab(true, true).align(GridData.FILL, GridData.FILL).applyTo(displayArea);
//xxx code change ends
        IWorkbenchSiteProgressService service = (IWorkbenchSiteProgressService) getSite()
                .getService(IWorkbenchSiteProgressService.class);
        if (service != null) {
            service.showBusyForFamily(JobFamilies.REPO_VIEW_REFRESH);
            service.showBusyForFamily(JobFamilies.CLONE);
        }
    }