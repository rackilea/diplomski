public void sortList(){
    if(size > 1){
        Node terminal = null; 
        while (head.next != terminal) {
            Node node = head;
            Node nextNode = head.next;

            while (nextNode != terminal) {
                if(node.data > nextNode.data){
                    int temp =node.data;
                    node.data = nextNode.data;
                    nextNode.data = temp;
                }
                node = nextNode;
                nextNode = nextNode.next;
            }
            terminal = node;
        }
    }
}