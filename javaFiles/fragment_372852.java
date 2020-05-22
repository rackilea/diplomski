public static void enque(int x){
    if(root==null){
        root=new Node(x);
        root.x=x;
        root.next=null;
        latest=root;
    }