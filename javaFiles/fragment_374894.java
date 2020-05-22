public void bfs(Tree parent){

    Iterator<V> ni = neighbors((V) parent.value());

    while(ni.hasNext()){
        V next = ni.next();
        GraphMatrixVertex<V> vert = dict.get(next);
        if(!vert.isVisited()){
            Tree newNode = new Tree(next);
            parent.addChild(newNode);
            newNode.bfs(this);
        }
    }
}