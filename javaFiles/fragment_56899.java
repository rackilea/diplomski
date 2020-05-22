// t is a thread running
while (true) {
    try {
        t.join(); 
    } catch (InterruptedException e) { e.printStackTrace(); }
    break;
}
t=null;