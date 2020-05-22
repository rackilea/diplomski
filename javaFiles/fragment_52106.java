List<Menu> menuItems = new ArrayList<Menu>();
menuItems = menuService.getAll();
for(int i=0; i<menuItems.size(); i++){                        //CHANGED
  Menu item = menuItems.get(i);                               //CHANGED
  if (item.getPageType() == 1 && item.getPageParent() > 0) {
    menuItems.get(item.getPageParent() - 1).getPageChildren().add(item);
    menuItems.remove(item);
  }
}