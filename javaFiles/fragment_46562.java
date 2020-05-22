public int remove(){
    if (isEmpty()){
        return -1;
    }
    else{//else remove

        int x = list[front];//reorder
        front = (front+1)%100;//rewind
        count--;
        return x;
    }
}