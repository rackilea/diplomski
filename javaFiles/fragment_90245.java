protected void tryToPrint() {
    while (true) {
        try {
            if (printer.isAvailable() && printer.isFair(this)) {
                synchronized(queue) {
                    if (queue.isEmpty()) 
                        break;

                    printer.requestToPrint(this, queue.get(0));
                    queue.remove(0);
                    synchronized (System.out) {
                        System.out.println(getName() + " printed. queue size: " + queue.size());
                    }
                }
            } else {
                printer.requestToPrintNext(this);
            }
        } catch (IllegalPrintStateException e) {
            e.printStackTrace();
        }
    }
}