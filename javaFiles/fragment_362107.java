@Override
protected MenuManager createMenuManager()
{
  MenuManager menuBar = new MenuManager();

  // Create "File" menu.
  MenuManager fileMenu = new MenuManager("File");
  menuBar.add(fileMenu);

  // Create "File" > "Test" action.
  Action testAction = new Action("&Test")
   {
     @Override
     public void run()
     {
       System.out.println("Test");
     }
   };
  fileMenu.add(testAction);

  return menuBar;
}

@Override
protected Control createContents(Composite parent)
{
  // Create contents.
  Label text = new Label(parent, SWT.NONE);
  text.setText("Lorem ipsum.");

  return text;
}