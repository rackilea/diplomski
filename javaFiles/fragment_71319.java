public void block() {
    setVisible(true);

    // Create a bunch of new threads...        
    firstCircleThr = new FirstCircleRepaintThread();
    firstCircleThr.setPriority(Thread.MAX_PRIORITY);
    firstCircleThr.start();
    secoundCircleThr = new SecoundCircleRepaintThread();
    secoundCircleThr.setPriority(Thread.MAX_PRIORITY);
    secoundCircleThr.start();
    lineThr = new LineRepaintThread();
    lineThr.setPriority(Thread.MAX_PRIORITY);
    lineThr.start();
}

public void unblock(){

    setVisible(false);
    // Dereference the old ones, but they are still running...        
    firstCircleThr = null;
    secoundCircleThr = null;
    lineThr = null;
    System.out.println("Yeah! OFF IT!");
}