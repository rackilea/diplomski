public void add()
    {
       Node current = head ; 
       if(head == null ){
           head = new Node(null); //here you need to initiate head
           for(int i = 0 ; i<6 ; i++){
               head.data[i] = numData[i] ; 
           }
       }
       else {
           while(current.next != null){
           current = current.next ; 
           }
           Node newNode = new Node(null); //initiating a new node
           for(int i = 0 ; i<6 ; i++){
               newNode.data[i] = numData[i] ;
           }
           current.next = newNode;
       }
    }