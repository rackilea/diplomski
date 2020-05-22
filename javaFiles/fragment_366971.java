Thread t = new Thread(new firstThread(i));
t.start();
try{
    t.join();
}catch(Exception e){}
System.out.println("Result : " + i.get());