public void list(){
    System.out.println("Queues");
    if(size==0){
        System.out.println("İs Empty");
        return;
    }

    Node tmp=head;
    while(tmp != tail.getNext()){
        System.out.println(tmp.getData() + " ");
        tmp= tmp.getNext();
    }
    System.out.println();
}