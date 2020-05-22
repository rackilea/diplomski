ItemList{ 
       content : bind [
                for (node in CustomNodes) 
                   if(node.isDismissed) [] else [node]
       ]
    }