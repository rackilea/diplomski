List<MenuButton> newButtons = new ArrayList<MenuButton>();
for (MenuButton m : menuButtonList) {
    // ...
    MenuButton m2=new MenuButton(order,b , vertical, p,name);
    newButtons.add(m2);
    // ...
}
for (MenuButton newButton : newButtons) {
    menuButtonList.add(newButton);
}