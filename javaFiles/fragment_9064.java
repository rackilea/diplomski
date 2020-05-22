//Remove parameter, it's not needed:
void BinarytoInt(){
    int x=128; int i=0;int total=0;
    //Link curr=new Link(temp);
    Link curr = head; //set curr to head reference

    while(curr.next!=null){
        if(curr.ld.binarybit=='1'){
            //total=total+(x*1);  //this is fine
            total += x;  //more elegant
        }
        curr=curr.next;
        x=x/2;  
    }//end while
    System.out.println(total);
}//end method