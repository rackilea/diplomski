protected final IExpansionListener expansionListener= new ExpansionAdapter()
{
  /**
   * {@inheritDoc}
   */
  @Override
  public void expansionStateChanged(ExpansionEvent e)
  {
    ScrolledForm form = ...; //your scrolled form goes here
    form.layout(new Control[] {(ExpandableComposite) e.getSource()}, SWT.ALL | SWT.CHANGED);
    form.reflow(true);
  }  
};

...

section.addExpansionListener(expansionListener);