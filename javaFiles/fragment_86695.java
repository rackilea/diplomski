public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Tree tree = new Tree(shell, SWT.NONE);

    for (int i = 0; i < 10; i++)
    {
        TreeItem item = new TreeItem(tree, SWT.NONE);
        item.setText("Parent " + i);

        for (int j = 0; j < 3; j++)
        {
            TreeItem child = new TreeItem(item, SWT.NONE);
            child.setText("Child " + i + " " + j);

            for (int k = 0; k < 3; k++)
            {
                TreeItem grandChild = new TreeItem(child, SWT.NONE);
                grandChild.setText("Child " + i + " " + j + " " + k);
            }
        }
    }

    final Menu menu = new Menu(tree);
    tree.setMenu(menu);
    tree.addMenuDetectListener(new MenuDetectListener()
    {
        @Override
        public void menuDetected(MenuDetectEvent e)
        {
            TreeItem treeItem = tree.getSelection()[0];

            e.doit = getLevelOfItem(treeItem) < 2;
        }
    });
    menu.addMenuListener(new MenuAdapter()
    {
        public void menuShown(MenuEvent e)
        {
            TreeItem item = tree.getSelection()[0];

            setMenu(menu, item);
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static void setMenu(Menu menu, TreeItem item)
{
    int level = getLevelOfItem(item);

    MenuItem[] items = menu.getItems();
    for (MenuItem i : items)
    {
        i.dispose();
    }

    switch (level)
    {
        case 0:
            for(int i = 0; i < 2; i++)
            {
                MenuItem newItem = new MenuItem(menu, SWT.NONE);
                newItem.setText("Menu item " + i);
            }
            break;
        case 1:
            for(int i = 0; i < 4; i++)
            {
                MenuItem newItem = new MenuItem(menu, SWT.NONE);
                newItem.setText("Menu item " + i);
            }
            break;
    }
}

private static int getLevelOfItem(TreeItem item)
{
    int counter = 0;

    while(item.getParentItem() != null)
    {
        item = item.getParentItem();
        counter++;
    }

    return counter;
}