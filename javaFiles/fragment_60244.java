Node delete(Node n){
        if(n==null){
            return null;
        }
        Node t = delete(n.next);
        if(t==null){
            return n; // i.e. right most node so just return this
        }
        else{
            Comparable c = (Comparable)n.k;
            if(c.compareTo((Comparable)t.k)<0){ //no need of this node so return t.
                return t;
            }
            else{
                n.next=t; //valid node so change the next pointer of current node
                return n;
            }
        }
    }