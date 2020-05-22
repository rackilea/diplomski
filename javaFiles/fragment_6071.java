if(currentNode != null){
    NodeIterator checkNode = currentNode.getNodes();

    while (checkNode.hasNext()) {
        Node imageNode = checkNode.nextNode();
        if(imageNode.hasProperty("fileReference")){
            Property fileReferenceProp = imageNode.getProperty("fileReference");
            printNodeTitle = fileReferenceProp.getString();
        }
    }
}