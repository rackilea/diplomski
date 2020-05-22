while(curr != null && counter < N){
        curr = curr.next;
        if(prev == null){                   
            prev = curr;
        }
        else{               
        prev.next = curr;
        }               
        counter ++;
    }