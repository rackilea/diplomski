public static int getHeight(Node n){
    if(n.isLeaf()){
         return 0;
    }else{
        int maxDepth = 0;

        foreach(Node child : n.getChildren()){
            maxDepth = Math.max(maxDepth, getHeight(child));
        }

        return maxDepth + 1;
    }
}