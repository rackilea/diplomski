System.out.println("before");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

System.out.println("after");