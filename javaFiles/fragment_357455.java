protected void createContents()
{
    shell.setLayout(new GridLayout(2, false));
    GridData grid = new GridData();
    grid.verticalAlignment = SWT.FILL;
    grid.verticalIndent = -6;
    Composite comp = new Composite(shell, SWT.None);

    comp.setLayout(new GridLayout());
    comp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
    Label label = new Label(comp, SWT.None);
    label.setText("Invertframe:");

    org.eclipse.swt.widgets.Group group = new org.eclipse.swt.widgets.Group(shell, SWT.None);
    GridLayout layout = new GridLayout(2, true);

    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;

    group.setLayout(layout);

    group.setLayoutData(grid);
    Button button = new Button(group, SWT.RADIO);
    GridData gd_button = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
    gd_button.verticalIndent = -2;
    button.setLayoutData(gd_button);

    button.setText("ON");
    Button button2 = new Button(group, SWT.RADIO);
    GridData gd_button2 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
    gd_button2.verticalIndent = -2;
    button2.setLayoutData(gd_button2);
    button2.setText("OFF");


    comp = new Composite(shell, SWT.None);

    comp.setLayout(new GridLayout());
    comp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
    label = new Label(comp, SWT.None);
    label.setText("Invertframe:");

    Composite composite2 = new Composite(shell, SWT.BORDER);
    layout = new GridLayout(2, true);
    composite2.setLayout(layout);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 10;
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginWidth = 0;

    button = new Button(composite2, SWT.RADIO);
    button.setText("ON");
    button2 = new Button(composite2, SWT.RADIO);
    button2.setText("OFF");
}