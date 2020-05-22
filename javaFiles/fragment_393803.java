public void startNode(NodeRef nodeRef)
    {
        this.currentName = (String)nodeService.getProperty(nodeRef, ContentModel.PROP_NAME);
        path.push(new Pair<String, NodeRef>(currentName, nodeRef));
        if (this.sr.getDictionaryService().isSubClass((nodeService.getType(nodeRef), ContentModel.TYPE_FOLDER))
        { ....