public class LinkedLst {
    public Node head;
    public Node prev;
    public Node last;

    public void add(String data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            prev = newNode;
            last = newNode;
            return;
        }else if(head == last){
            prev.next = newNode;
            last = newNode;
            return;
        }
        prev = prev.next;
        prev.next = newNode;
        last = newNode;
    }

    public void fwdPrintList() {
       Node temp = head;
       while (temp!=null){
           System.out.println(temp.data);
           temp = temp.next;
       }
    }

    public Node remove(){
        if(isEmpty()){
            System.out.println("List is Empty");
            return head;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }
    public boolean contains(String data) {
        Node temp = head;
        while (temp!=null){
            if (temp.data.equals(data)) {
                return true;
            }
        temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }
}