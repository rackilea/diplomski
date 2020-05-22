JMenu menu = new JMenu("Main Menu");

JMenu submenu = new JMenu("A menu within a menu");

JMenu subsubmenu = new JMenu("A menu within a menu within a menu");

JMenuItem itemFoo = new JMenuItem("Foo");
JMenuItem itemBar = new JMenuItem("Bar");
JMenuItem itemBaz = new JMenuItem("Baz");
JMenuItem itemQuz = new JMenuItem("Quz");

// These are OK

menu.add(subMenu);
subMenu.add(subsubmenu);
subMenu.add(itemFoo);
subMenu.add(itemBar);
subMenu.add(itemBaz);

// NO!

itemBaz.add(itemQuz);