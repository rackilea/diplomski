private void showErrorComposite(String topMessage, String bottomMessage, List<IStatus> statusList)
{
    final Composite errorComposite = new Composite(stackComposite, SWT.BORDER);
    final GridLayout layout = new GridLayout();
    layout.verticalSpacing = 20;
    errorComposite.setLayout(layout);
    errorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Label topLabel = new Label(errorComposite, SWT.WRAP | SWT.BORDER);
    topLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    topLabel.setText(topMessage);

    final Text errorList = new Text(errorComposite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL
                                                    | SWT.BORDER);
    final GridData gd_errorList = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_errorList.horizontalIndent = 20;
    errorList.setLayoutData(gd_errorList);

    for (int i = 0; i < statusList.size(); i++)
    {
        IStatus status = statusList.get(i);
        errorList.append("\u2022 " + status.getMessage());
        if (i != statusList.size() - 1)
            errorList.append("\n\n");
    }

    errorList.setTopIndex(0);

    final Label bottomLabel;
    if (bottomMessage != null)
    {
        bottomLabel = new Label(errorComposite, SWT.WRAP | SWT.BORDER);
        bottomLabel.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
        bottomLabel.setText(bottomMessage);
    }
    else
        bottomLabel = null;

    stackLayout.topControl = errorComposite;
    stackComposite.layout();
}