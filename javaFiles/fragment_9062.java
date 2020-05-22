// create new content node within company home
// assign name
String name = "Foundation API sample (" + System.currentTimeMillis() + ")";

// create content node
NodeService nodeService = registry.getNodeService();
ChildAssociationRef association = nodeService.createNode(
        companyHome,
        ContentModel.ASSOC_CONTAINS,
        QName.createQName(NamespaceService.CONTENT_MODEL_PREFIX, name),
        ContentModel.TYPE_CONTENT);