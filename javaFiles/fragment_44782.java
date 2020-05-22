@Override
  public void setVisible(final boolean visible)
  {
    super.setVisible(visible);

    if (visible) {
      final Shell shell = getShell();

      final Point size = shell.getSize();

      final Point newSize = ... calculate new size

      shell.setSize(newSize);
    }
  }