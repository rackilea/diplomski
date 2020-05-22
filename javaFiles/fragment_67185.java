public boolean visit(VariableDeclarationStatement node)
    {
        System.out.println("Visiting variable declaration statement.");
        for(int i = 0; i < node.fragments().size(); ++i)
        {
            VariableDeclarationFragment frag = (VariableDeclarationFragment)node.fragments().get(i);
            System.out.println("Fragment: " + node.getType() + " " + frag.getName());
        }

        System.out.println("");        
        return true;
    }