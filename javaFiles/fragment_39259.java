final Semaphore semaphore = new Semaphore(4); 

from("timer://GetOrder?period=1s")
            .to("bean:orderInfoDao?method=getNextOrder")
            .to("jms://process-orders")
            .process(new Processor() {
                 public void process(Exchange exchange) {
                     semaphore.acquire();
                 }
             })
            .end();

from("jms://process-orders?concurrentConsumers=4")
            .to("bean:orderService?method=processOrder(${body})")
            .process(new Processor() {
                 public void process(Exchange exchange) {
                     semaphore.release();
                 }
             })
            .to("direct:send-result")
            .end();