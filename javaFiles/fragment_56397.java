public void addChild(Node child)
    {
        if(children==null){
           children=new ArrayList<Node>();
        }

        children.add(child);
    }