public class Practice {
public static void main(String args[])
{
    //one runnable is created and shared by 3 threads
    final PrintNumbersConsecutively printRunnable = new
    PrintNumbersConsecutively();
    Thread t1 = new Thread(printRunnable, "Thread1");
    Thread t2 = new Thread(printRunnable,"Thread2");
    Thread t3 = new Thread(printRunnable,"Thread3");

    t1.start();
    t2.start();
    t3.start();
 }
}

 /** Each of the three threads are made to print 1 ,2 and 3 */

class PrintNumbersConsecutively implements Runnable
{
private Object monitor = new Object();
AtomicInteger atomicInt = new AtomicInteger(1);

static boolean one = true;
static boolean two = false;
static boolean three = false;

@Override
public void run()
{
    System.out.println(Thread.currentThread().getName()+"Started");
    printNumbers();
}

// method to print the numbers using 3 different threads 1 ,2 and 3
public void printNumbers()
{
    try
    {
        int i =0;
        while(i < 30)
        {
            synchronized (monitor)
            {
                /*System.out.println(Thread.currentThread().getName()+" held the lock of monitor");
                System.out.println("printVal is"+ atomicInt);*/
                //Thread1 should print 1
                if(Thread.currentThread().getName().equals("Thread1")) {
                    if (atomicInt.get() == 1) {
                        //prints 1 and next awakes second thread by setting
                        // atomic int to 2
                        System.out.print(1 + " ");
                        atomicInt.set(2);
                        monitor.notifyAll();
                       // System.out.println(Thread.currentThread().getName() + "Releasing the lock of monitor");
                    } else {
                        monitor.wait();
                    }
                }

                if(Thread.currentThread().getName().equals("Thread2")) {
                    if (atomicInt.get() == 2) {
                        //prints 1 and next awakes second thread by setting
                        // atomic int to 2
                        System.out.print(2 + " ");
                        atomicInt.set(3);
                        monitor.notifyAll();
                      //  System.out.println(Thread.currentThread().getName() + "Releasing the lock of monitor");
                    } else {
                        monitor.wait();
                    }
                }

                if(Thread.currentThread().getName().equals("Thread3")) {
                    if (atomicInt.get() == 3) {
                        //prints 1 and next awakes second thread by setting
                        // atomic int to 2
                        System.out.print(3 + " ");
                        atomicInt.set(1);
                        monitor.notifyAll();
                        //System.out.println(Thread.currentThread().getName() + "Releasing the lock of monitor");
                    } else {
                        monitor.wait();
                    }
                }
            }
            i++;
        }

    }
    catch(InterruptedException e)
    {
        //catches the interrupted excpeiton
    }
}