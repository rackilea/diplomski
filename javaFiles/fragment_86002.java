public void add(AnyType item){
    if(isEmpty()){
        q[f]=item;
    } 
    else {
        if (size == q.length) {
            AnyType[] copyQ = (AnyType[]) new Object[q.length*2];
            System.arraycopy(q, f, copyQ, 0, q.length-f);
            System.arraycopy(q, 0, copyQ, q.length-f, (r + 1));
            f = 0;
            r = q.length -1;
            q = copyQ;
        }
    }

    r = (r+1)%(q.length); 
    q[r]=item;
    size++;
}