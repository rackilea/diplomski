public static final DefaultMutableTreeNode getTreeNode(File file) throws IOException  {

    DefaultMutableTreeNode rootNode = null;
    Map<Integer, DefaultMutableTreeNode> levelNodes = new HashMap<Integer, DefaultMutableTreeNode>();
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;

    while( (line = reader.readLine()) != null ) {

        int level = getLevel(line);
        String nodeName = getNodeName(line, level);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodeName);               
        levelNodes.put(level, node);
        DefaultMutableTreeNode parent = levelNodes.get(level - 1);

        if( parent != null ) {
            parent.add(node);
        }
        else {
            rootNode = node;
        }
    }    
    reader.close();
    return rootNode;
}

private static final int getLevel(String line) {

    int level = 0;
    for ( int i = 0; i < line.length(); i++ ) {
        char c = line.charAt(i);
        if( c == '\t') {
            level++;
        }
        else {
            break;
        }
    }
    return level;
}

private static final String getNodeName(String line, int level) {
    return line.substring(level);
}