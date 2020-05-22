public doublyLinkedlist(String a) {

         String [] arr = a.split("");

         first = new Node(arr[0]);

         last = new Node(arr[arr.length-1]);

         first.setPrev(last);

         last.setNext(first);
         Node temp = first;
         for (int i=1 ; i<arr.length-1 ; i++)
         {
             Node newNode = new Node(arr[i]);
             temp.setNext(newNode);
             newNode.setPrev(temp);

             temp = temp.next;
         }

         //finally

         temp.prev.next = temp;
    }