JPanel panel=new JPanel();//FlowLayout is default
panel.setOpaque(false);//this tells the panel not to draw its background; looks nicer under LAFs where the background inside a tab is different from that of JPanel
panel.add(builtIn);
panel.add(above);
//...you get the picture; add all the stuff you already do, just use panel instead of c
JTabbedPane tabs=new JTabbedPane();
tabs.addTab("title", panel);//add a tab for the panel with the title "title"
//you can add more tabs in the same fashion - obviously you can change the title
tabs.addTab("another tab", comp);//where comp is a Component that will occupy the tab
mainFrame.setContentPane(tabs);//the JFrame will now display the tabbed pane