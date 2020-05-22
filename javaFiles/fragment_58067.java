package com.threading;

import java.util.ArrayList; 

import java.util.List;

public class TestConsumerProducer2 {

protected static int maxSize = 2;

static class Consumer implements Runnable {
    List<Integer> goods;

    public Consumer(List<Integer> goods) {
        this.goods = goods;
    }

    public void consume() {
        synchronized (goods) {

            while (goods.size() <= 0) {
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " >>>> consuming >>>" + goods.remove(0));
            goods.notifyAll();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            consume();
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

static class Producer implements Runnable {
    List<Integer> goods;

    public Producer(List<Integer> goods) {
        this.goods = goods;
    }

    public void produce(int i) {
        synchronized (goods) {

            while (goods.size() >= maxSize) {
                try {
                    goods.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ">>> producing >> " + i);
            goods.add(i);
            goods.notifyAll();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            produce(i);
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

public static void main(String[] args) {
    List<Integer> goods = new ArrayList<>();
    Consumer consumer = new Consumer(goods);
    Producer producer = new Producer(goods);
    Thread consumerWorker1 = new Thread(consumer);
    Thread consumerWorker2 = new Thread(consumer);

    Thread prroducerWorker1 = new Thread(producer);
    Thread prroducerWorker2 = new Thread(producer);

    consumerWorker1.start();
    consumerWorker2.start();
    prroducerWorker1.start();
    prroducerWorker2.start();

    try {
        consumerWorker1.join();
        consumerWorker2.join();
        prroducerWorker1.join();
        prroducerWorker2.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Job completed >>>>");
}

}