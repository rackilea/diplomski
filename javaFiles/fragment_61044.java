// This loop runs twice total
    for (int i=0; i < nodes.getLength(); i++)
    {
        ...

        if (node.getNodeType() == Node.ELEMENT_NODE) 
        {
            ...
            if (update_type.equals("JGRP"))
            { 
                ...
                // This loop runs twice total
                for (int z=0; z < cNodes.getLength(); z++)
                { 
                    ...

                    if (cNode.getNodeType() == Node.ELEMENT_NODE)
                    {   
                        ...

                        System.out.println(g_name);
                    }
                }                           
            }
        }
    }