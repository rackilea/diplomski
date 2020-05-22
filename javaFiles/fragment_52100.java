...
MUIElement window = modelService.find("main.window.id", app);
setMenuItem((MHandledMenuItem) findMenuElement("menu.item.id", window));
...

public static MMenuElement findMenuElement(String id, MUIElement searchRoot)
{
    if (id == null) {
        throw new IllegalArgumentException("id is null!");
    }

    if (id.length() == 0) {
        throw new IllegalArgumentException("Empty string is not allowed in id.");
    }

    if (searchRoot instanceof MMenuElement && id.equals(searchRoot.getElementId()))
    {
        return (MMenuElement) searchRoot;
    }

    if (searchRoot instanceof MTrimmedWindow)
    {
        MMenuElement findMenu = findMenuElement(id, ((MTrimmedWindow) searchRoot).getMainMenu());
        if (findMenu != null)
        {
            return findMenu;
        }
    }
    else if (searchRoot instanceof MPart)
    {
        List<MMenu> menus = ((MPart) searchRoot).getMenus();
        for (MMenu mm : menus)
        {
            MMenuElement findMenu = findMenuElement(id, mm);
            if (findMenu != null)
            {
                return findMenu;
            }
        }
    }
    else if (searchRoot instanceof MMenu)
    {
        List<MMenuElement> children = ((MMenu) searchRoot).getChildren();
        for (MMenuElement me : children)
        {
            MMenuElement findMenu = findMenuElement(id, me);
            if (findMenu != null)
            {
                return findMenu;
            }
        }
    }
    return null;
}