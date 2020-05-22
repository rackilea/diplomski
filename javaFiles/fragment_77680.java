for (int i = 0; i < serverThreads; i += 1) {
    CommandExecutionThread newThread = new CommandExecutionThread(bank, queue, executeCommandInsideMonitor);
    threads[i] = newThread;
    newThread.start();
    System.out.println(newThread.isAlive()); 
}