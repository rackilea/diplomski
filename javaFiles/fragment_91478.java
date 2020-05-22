public HashMap<String,Object> nestedMap(Node node) {

           HashMap<String, Object> map = new LinkedHashMap<>();

           PropertyIterator pi;
            try {
                pi = node.getProperties();
                //Get properties for the root node
                   while(pi.hasNext())
                    {
                       Property p = pi.nextProperty();
                       String name = p.getName();
                       String val = p.getString();

                       map.put(name,val);

                    }//end of while for properties of root node
            } catch (RepositoryException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


           Iterable<Node> children;
            try {
                children = NodeUtil.getNodes(node);
                for (Node child : children) {

                    if (!child.getPrimaryNodeType().getName().contains("mgnl:page")) {  
                      map.put (child.getName(), nestedMap(child));

                   }//end of checking if PrimaryNodeType is of type mgnl:page
                }

            } catch (RepositoryException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return map;
        }