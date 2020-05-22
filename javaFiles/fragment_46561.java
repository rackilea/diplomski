public boolean insert(int n){

    if (isFull()){
        //not inserted
        return false;
    }
    else{

       //make it the first in queue if queue is empty
       if (isEmpty()){ //use empty
           front=0;//just set it 
           rear=0;//just set it 
       }
       list[rear] = n;
       rear = (rear+1)%100; //just rewind it when it reaches 100 index 0 must be free at this point

       count++;
       return true;
    }

}