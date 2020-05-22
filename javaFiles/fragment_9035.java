HashMap<Node, String> xpathCache;
HashMap<Node, Integer> nodeIndexCache;

public String getElementXpath(DOMElement elt){
            String path = "";

            for (Node fib = (Node) elt; fib != null; fib = fib.getParentNode()){                
                if (fib.getNodeType() == Node.ELEMENT_NODE){

                    String cachedParentPath = xpathCache.get(fib);

                    if (cachedParentPath != null){
                        path = cachedParentPath + path;
                        break;
                    }

                    DOMElement thisparent = (DOMElement) fib;
                    int idx = getElementIdx(thisparent);
                    String xname = thisparent.getTagName();

                        if (idx >= 1) xname += "[" + idx + "]";
                        path = "/" + xname + path;
                }
            }

            /* 
             * here, not only you know the xpath to the elt, you also 
             * know the xpath to the ancestors of elt. You can leverage
             * this to cache the ancestor's xpath as well. But I just 
             * cache the elt for illustration purpose.
             * 
             * To compute ancestor's xpath efficiently, maybe you want to 
             * store xpath using different data structure other than String.
             * Maybe a Stack of Strings?
             */
            if (! xpathCache.containsKey(elt)){
               xpathCache.put (elt, path);
            }

            return path;           
        }

private int getElementIdx(DOMElement elt) {
             Integer count = nodeIndexCache.get(elt);
             if (count != null){
               return count;
             }
             count = 1;

             LinkedList<Node> siblings = new LinkedList<Node>();
             for (Node sib = elt.getPreviousSibling(); sib != null; sib =           sib.getPreviousSibling())
                {
                   siblings.add(sib);
                }

             int offset = 0;
             for (Node n : siblings)
             {
                nodeIndexCache.put(n, siblings.size() - index);
                offset ++;
             }                

            /* 
             * you can improve index caching even further by doing it in the
             * above for loop.
             */      
            nodeIndexCache.put(elt, siblings.size()+1);

            return count;
}