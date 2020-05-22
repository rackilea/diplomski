Node temp=null;
r=a.reverse(root,temp);

public Node reverse(Node node,Node temp) {
    if (node!=null){
        Node n=new Node();
        n.data=node.data;
        n.next=temp;
        temp=n;
        node=node.next;
        return reverse(node,temp); // Here now we return this result
    }
return temp;    
}