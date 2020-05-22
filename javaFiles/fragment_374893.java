int weight; // this should be you node traversal cost

public LinkedList<Tree> bfs(Tree parent){

    Iterator<V> ni = neighbors((V) parent.value());

    LinkedList bestPath = null;       
    int bestScore = 0xFFFFFFFF;

    while(ni.hasNext()){
        V next = ni.next();
        GraphMatrixVertex<V> vert = dict.get(next);
        if(!vert.isVisited()){
            Tree newNode = new Tree(next);
            parent.addChild(newNode);
            LinkedList path = newNode.bfs(this);
                if(newNode.weight < bestScore){
                    bestScore = weight;
                    bestPath = path;
                }
        }
    }
    weight = bestScore + this.weight;
    bestPath.addFirst(this);
    return path;   
}