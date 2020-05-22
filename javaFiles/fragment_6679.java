DefaultMutableTreeNode server = new DefaultMutableTreeNode(new TreeNodeModel(0,"Server 01", false));

DefaultMutableTreeNode userFolder = new DefaultMutableTreeNode(new TreeNodeModel(1, "User Folders", false));
server.add(userFolder);

DefaultMutableTreeNode user01 =  new DefaultMutableTreeNode(new TreeNodeModel(2, "User 01", true, true));
userFolder.add(user01);

DefaultMutableTreeNode clientA = new DefaultMutableTreeNode(new TreeNodeModel(3, "Client A", true, true));
user01.add(clientA);

DefaultMutableTreeNode clientB = new DefaultMutableTreeNode(new TreeNodeModel(4, "Client B", true, true));
user01.add(clientB);

DefaultMutableTreeNode publicFolder = new DefaultMutableTreeNode(new TreeNodeModel(5, "Public Folders", false));
server.add(publicFolder);

DefaultMutableTreeNode clientC = new DefaultMutableTreeNode(new TreeNodeModel(6, "Client C", true));
publicFolder.add(clientC);
        Tree_Nodes.setCellRenderer(new TreeNodeRenderer());
        Tree_Nodes.setCellEditor(new TreeNodeEditor(Tree_Nodes));
Tree_Nodes.setModel(new DefaultTreeModel(server);