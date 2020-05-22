public void populateMibValues()
{

    final DefaultTreeModel model = (DefaultTreeModel) this.m_mibTree.getModel();
    model.setRoot(null);

    this.rootNode.removeAllChildren();
    final String query_MibNodeDetailsSelect = "Select * from MIBNODEDETAILS where LENGTH(mn_oid)<=9 "
            + " and mn_OID<='1.3.6.1.4.1' order by mn_OID"; // only

    this.innerNodeNames.clear();
    this.innerNodes.clear();
    this.innerNodesOid = null;

    try {
        final ResultSet deviceRS = Application.getDBHandler().executeQuery(query_MibNodeDetailsSelect, null);// inner
        // nodes

        while (deviceRS.next()) {
            final mibNode mb = new mibNode(deviceRS.getString("mn_OID").toString(), deviceRS.getString("mn_name")
                    .toString());
            mb.m_Type = Integer.parseInt(deviceRS.getString("mn_nodetype").toString());
            createMibTree(mb);
        }
    }
    catch (final Exception e) {
        Application.showErrorInConsole(e);
        NmsLogger.writeErrorLog("ERROR creating MIB tree failed", e.toString());
    }