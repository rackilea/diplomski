public int getLevel(){
    Node temp = parent;
    int depth = 0;
    while(temp != null){
        depth++;
        temp = temp.parent;
    }
    return depth;
}