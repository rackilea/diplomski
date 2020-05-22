public Queue(Queue other){

    if(other != null){
        PersonQueueElement node = other.head;
        while(node != null){
            this.insert(node.getValue());
            node =node.getNext();
        }
    }

}