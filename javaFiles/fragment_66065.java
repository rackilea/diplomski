Node linkList =new Node(1); // linkList now Points to 1stNode
linkList.appendToTail(1); // linkList still points to 1stNode - add a link inside 1st Node to 2nd Node
linkList.appendToTail(1); // linkList still points to 1stNode - add a link inside 2st Node to 3rd Node
linkList.appendToTail(2); // linkList still points to 1stNode - add a link inside 3rd Node to 4th Node
DateTest dt = new DateTest();
dt.removeLinkListNodeDuplication(linkList);

//linkList still points to 1stNode - but the link is now modified from 2ndNode to 4thNode




public void removeLinkListNodeDuplication(Node listNode) {
    Node previous =null;
    Hashtable<Integer,Boolean> hashtable=new Hashtable<Integer, Boolean>();
    while (listNode!=null){
        if(hashtable.containsKey(listNode.data)){
            previous.next =listNode.next; 
            // 2nd Iteration - previous points to 1stNode - modify link inside 1stNode to 3rd Node
            // 3rd Iteration - previous points to 1stNode - modify link inside 1stNode to 4th Node

        }
        else{
            hashtable.put(listNode.data,true);
            previous =listNode; 
            //1st Iteration previous points to 1stNode
            //4thIteration  previous points to 4thNode
        }

        listNode = listNode.next; 
        //1st Iteration listNode points to 2ndNode
        //2nd Iteration listNode points to 3rdNode
        //3rd Iteration listNode points to 4thNode
        //4th Iteration listNode points to Null
    }
    //listNode is null ?!
    // listNode now points to Null

}