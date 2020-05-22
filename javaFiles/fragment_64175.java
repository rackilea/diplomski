public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Thread.sleep(millisecondsToSleep);
                if (!kitchen.processedOrdersEmpty()) {
                    Order processedOrder = kitchen.getFromProcessedOrders();
                    kitchen.printMessage("took order#" + processedOrder.getOrderNumber());
                    Thread.sleep(millisecondsToServe);
                    kitchen.printMessage("served order#" + processedOrder.getOrderNumber());
                } else {
                    int currentRandom = getNextRandom();
                    if (currentRandom <= 10) {
                        Order newOrder = new Order(kitchen.getLastOrderNumber());
                        kitchen.puIntoUnprocessedOrders(newOrder);
                        kitchen.printMessage("generated new order#" + newOrder.getOrderNumber());
                    } else {
                        Thread.sleep(millisecondsToSleep);
                    }
                }
            } catch (InterruptedException ex) { 
                //... handle ...
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }