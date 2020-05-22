void enqueue(int number) throws InterruptedException
{

    synchronized(lock)
    {
        if(isFull())
           lock.wait();

        array[rear] = number;
        System.out.println("Rear is:"+ rear+ "value is:"+number+"Size is:"+size);

        rear = (rear+1)%size;
        count++;
        lock.notify();
    }
}

void dequeue() throws InterruptedException
{
    synchronized(lock)
    {
        if(isEmpty())
           lock.wait();

        int retVal = 0;
        retVal = array[front];
        System.out.println("Front is:"+ front+ "value is:"+retVal);

        front = (front+1)%size;
        count--;
        lock.notify();
    }

}