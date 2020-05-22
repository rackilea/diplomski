int maxDepthDfs(int root){
//since we are only calling this function for root nodes we need not check if nodes were previously visited
int depth=1;
for(int i=0;i<adjList[root].size();i++){
    int child=adjList[root].get(i);
    depth=Math.max(maxDepthDfs(child)+1,depth);
}
s.push(root);
return depth;
}
public int getSolution(){
    s=new Stack<Integer>();
    int ans=0;
    for(int i=0;i<V;i++){
        if(!notRoot[i])
            ans=Math.max(ans,maxDepthDfs(i));
    }
    //stack s contains result of topological sort;
    return ans;
}