class ThreadA implements Runnable{
public void run(){
//do something
}
public void setSomething(){}
}

class ThreadB implements Runnable{
private ThreadA aref;
public ThreadB(ThreadA ref){aref=ref;}
public void run(){
    aref.setSomething();//calling the setSomething() with this thread!! no thread a
}
}

class Foo{
public static void main(String...arg){
  ThreadA a=new ThreadA();
  new Thread(a).start();
  ThreadB b=new ThreadB(b);
  new Thread(b).start();
}
}