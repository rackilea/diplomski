public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    CheckboxTreeViewer tv = new CheckboxTreeViewer(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    GridData gridData = new GridData(GridData.FILL_BOTH);
    tv.getTree().setLayoutData(gridData);
    tv.setAutoExpandLevel(3);
    tv.setContentProvider(new FeaturePropertyDialogContentProvider());
    tv.setInput("root");

    shell.setSize(200, 200);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static class FeaturePropertyDialogContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return this.getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        switch ((String) parentElement) {
            case "root":
                return new String[]{"Platform XYZ12", "Platform ZUPP"};
            case "Platform XYZ12":
                return new String[]{"Microcontroller TPU23"};
            case "Platform ZUPP":
                return new Object[]{"Sensor", "Precaler IO"};
            case "Sensor":
                return new Object[]{"unknown child 1", "unknown child 3"};
            default:
                return new String[0];
        }
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return this.getChildren(element).length > 0;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}