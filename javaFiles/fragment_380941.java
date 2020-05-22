@Execute
public void execute(@Optional MMenuItem menuItem, ..... other parameters)
{
   if (menuItem != null) {
      String iconUrl = menuItem.getIconURI();
      ...
   }
}