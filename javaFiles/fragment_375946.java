public class ReplaceWidgetComposite
    extends Composite
{
    private Label label;
    private Text text;
    private Button button;

    public ReplaceWidgetComposite(Composite parent, int style)
    {
        super(parent, style);

        setLayout(new GridLayout(1, false));

        label = new Label(this, SWT.NONE);
        label.setText("This is a label!");

        button = new Button(this, SWT.PUSH);
        button.setText("Press me to change");
        button.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                text = new Text(ReplaceWidgetComposite.this, SWT.BORDER);
                text.setText("Now it's a text!");
                text.moveAbove(label);
                label.dispose();
                button.dispose();
                ReplaceWidgetComposite.this.layout(true);
            }
        });
    }
}