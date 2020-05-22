public class StatusLineControl
{
  public StatusLineControl()
  {
  }

  @PostConstruct
  public void postConstruct(Composite parent, StatusLineManager manager)
  {
    Composite body = new Composite(parent, SWT.NONE);

    body.setLayout(GridLayoutFactory.fillDefaults().extendedMargins(10, 0, 4, 0).create());

    Label label = new Label(body, SWT.NONE);

    label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

    // Tell the manager about the label

    manager.setLabel(label);
  }
}