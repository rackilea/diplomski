private void() updateTitle() {
  SwingUtilities.invokeLater( new Runnable()
  {
    @Override
    public void run( )
    {
      setTitle(((filename == null) ? "untitled" : filename) + ((unsaved) ? "*" : ""));
    }
  });
}