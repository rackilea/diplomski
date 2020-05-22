public static void main(String[] args)
{
    new MyDialog(new Shell(new Display())).open();
}

private static class MyDialog extends Dialog
{
    protected MyDialog(Shell parentShell)
    {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    @Override
    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Stackoverflow");
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite comp = (Composite) super.createDialogArea(parent);

        // Part one
        Label one = new Label(comp, SWT.NONE);
        one.setText("Label1");
        new Label(comp, SWT.NONE);
        Text textOne = new Text(comp, SWT.BORDER);
        textOne.setText("Textbox1");
        Button buttonOne = new Button(comp, SWT.PUSH);
        buttonOne.setText("Button1");

        // Part two
        Label two = new Label(comp, SWT.NONE);
        two.setText("Label2");
        new Label(comp, SWT.NONE);
        List listOne = new List(comp, SWT.BORDER);
        listOne.add("List1");
        Composite buttonCompOne = new Composite(comp, SWT.NONE);
        Button buttonTwoOne = new Button(buttonCompOne, SWT.PUSH);
        buttonTwoOne.setText("Button2");
        Button buttonTwoTwo = new Button(buttonCompOne, SWT.PUSH);
        buttonTwoTwo.setText("Button3");

        // Part three
        Label three = new Label(comp, SWT.NONE);
        three.setText("Label3");
        new Label(comp, SWT.NONE);
        List listTwo = new List(comp, SWT.BORDER);
        listTwo.add("List2");
        Composite buttonCompTwo = new Composite(comp, SWT.NONE);
        Button buttonThreeOne = new Button(buttonCompTwo, SWT.PUSH);
        buttonThreeOne.setText("Button4");
        Button buttonThreeTwo = new Button(buttonCompTwo, SWT.PUSH);
        buttonThreeTwo.setText("Button5");

        // Layout stuff
        comp.setLayout(new GridLayout(2, false));
        GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        buttonCompOne.setLayout(layout);
        layout = new GridLayout(1, false);
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        buttonCompTwo.setLayout(layout);
        textOne.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        buttonOne.setLayoutData(new GridData(SWT.END, SWT.TOP, false, true));
        listOne.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        listTwo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        buttonCompOne.setLayoutData(new GridData(SWT.END, SWT.TOP, false, true));
        buttonCompTwo.setLayoutData(new GridData(SWT.END, SWT.TOP, false, true));

        return comp;
    }
}