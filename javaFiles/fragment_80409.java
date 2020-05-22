public void deleteSameInSortedList(){
    CharNode p=head.getNext();
    CharNode temp=p;
    boolean flag=false;
    for(p = head; p != null; p = p.getNext()){
        flag=false;
        temp=p;
        while(p.getNext()!=null&& p.getLetter()==p.getNext().getLetter()){      
            flag=true;
            p = p.getNext(); 
        }
        if(flag){
            temp.setNext(p.getNext());
        }
    }
}