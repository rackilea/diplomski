@Override
public boolean close()
{
    getShell().getDisplay().removeFilter(SWT.KeyDown, listener);
    super.close();
}