...

  private List<Nachricht> unread;
  private MenuModel unreadMenu;

  ...

  public void initUnread() {
    unread = nachrichtFacade.findAllUnread(
            personLoginController.getCurrentUser().getMandant(),
            personLoginController.getCurrentUser());

    unreadMenu = new DefaultMenuModel();
    Integer menuItemId = 1;
    for (Nachricht nachricht : unread) {
      menuItemId++;
      DefaultMenuItem menuItem = new DefaultMenuItem(nachricht.getTeaserText());
      menuItem.setId(menuItemId.toString());
      String nachrichtIdString = nachricht.getId().toString();
      menuItem.setCommand("#{nachrichtTeaserController.show('" + nachrichtIdString + "')}");
      //menuItem.setCommand(String.format("#{nachrichtTeaserController.show('%d')}",unread.indexOf(n)));
      unreadMenu.addElement(menuItem);
    }
}

...

public String show(String nachrichtIdString) {
  Long nachrichtId = Long.valueOf(nachrichtIdString);
  Nachricht nachricht = nachrichtFacade.find(nachrichtId);
  return show(nachricht);
}