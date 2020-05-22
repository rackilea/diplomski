Map<String, TreeNode> rootNodes = new HashMap<String, TreeNode>();

 //Retrieve the list of root Nodes. eg Tables in the database.
 for(Table table : databaseTables){

    //table.getTableName() will be the name of the node, it could be something like "music" or "documents"
    rootNodes.add(table.getTableName(), new DefaultTreeNode(table.getTableName(), new Document......, root);
 }