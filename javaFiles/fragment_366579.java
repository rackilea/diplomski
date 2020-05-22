public static void main(String args[]) {
    dispatcher d = new dispatcher();
    readyQueue = new PriorityQueue<>();
    blockedQueue = new PriorityQueue<>();
    Process p1 = newProcess(processNo++, 2, "Running"); // <--- HERE
    ...