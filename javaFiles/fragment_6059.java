// Demonstration code only, may not feature best practices
LinkedList<Runnable> q = new LinkedList<>();
while(true) {
    Runnable task = q.remove(); // removes the first element
    task.execute()
}