public graph(int V){
    this.V = V;
    this.array = new AdjList[V];
    int i;
    for(i=0;i<V;++i){
        this.array[i] = new AdjList();
    }
}