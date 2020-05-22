// add new JPanel to TabbedPane via a reusable Class
MoreTabs mt1 = new MoreTabs("Label 1");
MoreTabs mt2 = new MoreTabs("Label 2");
MoreTabs mt3 = new MoreTabs("Label 3");

tabbedPane1.addTab( "More Tabs 1", mt1);
tabbedPane1.addTab( "More Tabs 2", mt2);
tabbedPane1.addTab( "More Tabs 3", mt3);