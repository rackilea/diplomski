public void add(int index, Customer customer) {
    int size = size();
    Customer tmp=listPtr,tmp2;
    int i=0;
     //some boundary cases
    if((index<0) ||(index>size)){
       return;
    }
    //assumes all other cases are handled
    while (i != size) {            
        if ((i+1) == index) {
            System.out.println(size + ":" + index);
            tmp2=tmp.next;
            tmp.next=customer;
            customer.next=tmp2;
            break;
        }
        tmp=tmp.next;
        ++i;
    }
}