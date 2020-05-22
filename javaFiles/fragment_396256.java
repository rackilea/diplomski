@Override
public void clearTable() {
    try {
        /**
         * All nodes are linked except the root. So we need to start deleting the leaves first.
         */
        while (new XincoCoreNodeJpaController().findXincoCoreNodeEntities().size() > 0) {
            for (com.bluecubs.xinco.core.server.persistence.XincoCoreNode xcn : getLeaves()) {
                new XincoCoreNodeJpaController().destroy(xcn.getId());
            }
        }
    } catch (XincoException ex) {
        Logger.getLogger(XincoCoreNodeServer.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private Vector<com.bluecubs.xinco.core.server.persistence.XincoCoreNode> getLeaves() throws XincoException {
    Vector<com.bluecubs.xinco.core.server.persistence.XincoCoreNode> leaves =
            new Vector<com.bluecubs.xinco.core.server.persistence.XincoCoreNode>();
    result = XincoDBManager.protectedCreatedQuery("select x from XincoCoreNode x " +
            "where x.id not in (select y.xincoCoreNodeId.id from XincoCoreNode y " +
            "where y.xincoCoreNodeId is not null)",null,true);
    if (result.size() == 0) {
        //Check if the root is there
        for (Object o : new XincoCoreNodeJpaController().findXincoCoreNodeEntities()) {
            leaves.add((com.bluecubs.xinco.core.server.persistence.XincoCoreNode) o);
        }
    }
    for (Object o : result) {
        leaves.add((com.bluecubs.xinco.core.server.persistence.XincoCoreNode) o);
    }
    return leaves;
}