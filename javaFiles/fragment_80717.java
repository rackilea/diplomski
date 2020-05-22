ArrayList<Node> children = current.getChildren();
            closed.addLast(current);
            // *** Not like this ***
            // for (Node child : children) {
            //    if (!open.contains(child) && !closed.contains(child)) {
            //        open.addFirst(child);
            //    }
            //}
            // **** But like this ****
            for(int i=children.size()-1; i>=0; i-- ) {
                Node child=children.get(i);
                if (!open.contains(child) && !closed.contains(child)) {
                    open.addFirst(child);
                }
            }
            // If you are **absolutely** sure your structure is a 
            // Tree (thus, no cycles) then testing against 
            // open/closed is unnecessary and the code can be simplified: as
            // open.addAll(0, children);