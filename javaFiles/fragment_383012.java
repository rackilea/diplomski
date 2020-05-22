MTrimmedWindow trim = (MTrimmedWindow) modelService.find("your-window-id", application);
MMenu menu = (MMenu)modelService.find("your-menu-id", trim.getMainMenu());
if(menu != null) {
    for(MMenuElement item : menu.getChildren()) {
        if(item instanceof MHandledMenuItem && item.getElementId().contains("some-common-string-in-the-menuitem-id")) {
                item.setContributorURI("platform:/plugin/com.example.yourcontributingplugin");
        }
    }
}