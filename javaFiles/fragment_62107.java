private NodeList compileToNodeList(String pattern, Document document){
        NodeList compiledNodeList = null;
        try{
            compiledNodeList = (NodeList) xPath.compile("/*/UserList/User").evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e){
            //TODO code for logging
            e.printStackTrace();
        }
        return compiledNodeList;
   }