void displayQueue() {
    while (!testQ.isEmpty())
    {   
    Task p = testQ.poll(); // poll, you want to remove the head
    System.out.format("Task Priority %d \n", p.priority);
    }
}