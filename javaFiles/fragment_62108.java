private NodeList compileToNodeList(String pattern, Document document){
        NodeList compiledNodeList = null;
        try{
            compiledNodeList = (NodeList) xPath.compile("/*/UserList/User").evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e){
            throw new IllegalStateException("Unable to create the compiled node list: " + e.getMessage(), e);
        }
        return compiledNodeList;
 }