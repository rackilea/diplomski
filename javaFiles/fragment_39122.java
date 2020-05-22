package com.dummy.aspectj;
public aspect LaterAspect{

    pointcut laterInstantiation() :
        execution(@Later *.new(..))    ;

    void around() : laterInstantiation() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Wait... this is too heavy");

                try{
                    Thread.sleep(2000);
                } catch(final InterruptedException e){
                    throw new IllegalStateException(e);
                }
                System.out.println("OK, now I am up to the task");
                proceed();
            }
        }).start();
    }

}