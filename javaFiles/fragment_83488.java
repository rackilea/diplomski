public void addNode(Node front ,String name){
    Node tail;
    if(isListEmpty(front)){
        this.front = makeNode(name);
    } 
    else {
        tail = findTail(front);
        tail.next = makeNode(name);
    }
}