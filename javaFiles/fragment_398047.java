myTreeModel.treeNodesChanged(
        new TreeModelEvent(
           this,
           new Object[] { myNodeA }, // Path to the _parent_ of changed item
           new int[] { 1 },          // Indexes of changed nodes
           new Object[] { myNodeC }, // Objects represents changed nodes
                                     //    (Note: old ones!!! 
                                     //     I.e. not "C2", but "C",
                                     //     in this example)
           )
        );