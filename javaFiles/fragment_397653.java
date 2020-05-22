public void showNodeTypes(){

        NodeTypeManager manager;
        try {
            manager = (NodeTypeManager)jcrSession.getWorkspace().getNodeTypeManager();

            NodeTypeIterator nodeTypeIterator = manager.getAllNodeTypes();
            NodeType actual;

            while (nodeTypeIterator.hasNext()){
                System.out.println("----------------");
                actual= (NodeType)nodeTypeIterator.next();
                System.out.println(actual.getName());
                for(PropertyDefinition propertyDef:actual.getPropertyDefinitions()) {
                    System.out.println(propertyDef.getName() +" --> Mandatory: " + propertyDef.isMandatory());
                }
            }

        } catch (RepositoryException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }