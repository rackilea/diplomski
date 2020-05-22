Thread[] threads = new Thread[20];

for (int i = 0; i < threads.length; i++) {
    threads[i] = new Thread(new mthread());
    threads[i].start();
}       

for (int i = 0; i < threads.length; i++) {
    System.out.println(i + " isAlive() = " + threads[i].isAlive());
}

try {
    for (int i = 0; i < threads.length; i++){       
        threads[i].join();           
    }
} catch (InterruptedException e) {          
    e.printStackTrace();
}
for (int i = 0; i < threads.length; i++) {
    System.out.println(i + " isAlive() = " + threads[i].isAlive());
}