Panel panel = new Panel();
panel.setSizeFull();
panel.getContent().setSizeUndefined();
tab.addComponent(panel);
tab.setExpandRatio(panel, 1);

Tree tree = new Tree();
tree.setSizeUndefined();
panel.addComponent(tree);