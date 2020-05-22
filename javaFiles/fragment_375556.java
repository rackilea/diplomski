@Override
public void createPartControl(Composite parent) {
    parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    parent.setLayout(new FillLayout(SWT.HORIZONTAL));

    ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    scrolledComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setExpandVertical(true);
    scrolledComposite.setMinWidth(400);
    scrolledComposite.setMinHeight(400);

    Composite myViewParent = new Composite(scrolledComposite, SWT.NONE);
    myViewParent.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
    myViewParent.setLayout(null);

    Button btnNewButton = new Button(myViewParent, SWT.NONE);
    btnNewButton.setBounds(45, 237, 90, 30);
    btnNewButton.setText("New Button");

    scrolledComposite.setContent(myViewParent);
    scrolledComposite.setMinSize(myViewParent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    parent.setSize(600, 300);