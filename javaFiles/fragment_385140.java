public void insertNode(int t,int j, String name){  
   Node node = new Node(t,j,name);
   if(ptr == null){
       ptr = node;
   } else {
     node.next = ptr;
     ptr.prev = node;
     ptr = node;
   }