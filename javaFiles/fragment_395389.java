Iterator<JsonNode> itr = rootNode.iterator();

    while(itr.hasNext()){
        JsonNode personNode = itr.next();
        if(personNode  instanceof ObjectNode){
           if (personNode.has("keyToRemove")) {
             // ObjectNode object = (ObjectNode) personNode;  
             // object.remove("keyToRemove");
             itr.remove();
           }
        }
    };