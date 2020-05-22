public int removeAllBasedOnInputValue(int val){
    if (isEmpty())
    {
       System.out.println("empty");
        return 0;
    }else{

        int counter=0;
        node current=start;

        //here we will go to the last node
        while(current.next != null){
            if(current.data > val){
                /* Here, we need to verify 3 things:
                * 1 - If it is the start;
                * 2 - If it is the end; and
                * 3 - If it is the body.
                */

                /*1st verification - 
                If the start is bigger than your value,
                then you just make your next node as "start",
                and make its previous as NULL.*/
                if(current == start)
                {
                    start = current.next;
                    current.next.prev = null;
                }/*2nd verification - 
                If it is the last element,
                then you just make the next node of your previous be NULL.*/
                else if(current.next == null)
                {
                    current.prev.next = null;
                }/*3rd verification - 
                You will make the next of the previous as your current next; 
                and the previous of the next as your current previous. 
                In that way you will lose all the ways of reaching the current 
                (which is greater than the value)*/
                else
                {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                counter++;
            }
            current.next = current.next;
        }

    return counter;
    }
}