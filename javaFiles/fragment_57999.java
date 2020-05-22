for (int i=0; i<=N; N++)
        if (i==index){
            temp.next=current.next;
            current.next=temp;
        }else{
         current=current.next;
       }