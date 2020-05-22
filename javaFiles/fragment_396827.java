public void add(Customer newNode, int dummy) {  
    CustomerList before = null;
    boolean inserted = false;
    if (head == null) {  //first node   
        head = tail = this;
        head.setData(newNode);
        return;
    } else {
        CustomerList curr = head;
        while(curr != null) {
            String currentName = curr.getData().getName();
            String newNodeName = newNode.name;
            if (currentName.compareToIgnoreCase(newNodeName) > 0) {

                CustomerList cList = new CustomerList(newNode);
                cList.setNext(curr);//curr is greater than clist, therefore cList's next element is curr
                if(before!=null)
                    before.setNext(cList);
                else {  //this tests the case when 
                    //the newNode goes at the BEGINNING of the list
                    head = cList;
                }
                curr = cList;
                inserted = true;
                return;
            }
            before = curr;
            curr = curr.next;               
        }
    }
    if(!inserted) {
        add(newNode);
    }

} // add