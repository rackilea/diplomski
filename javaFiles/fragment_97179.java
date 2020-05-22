public synchronized WorkOrder getWorkOrder() throws InterruptedException {
    while(mWorkOrderList.size() == 0){
        this.wait();
    }

    return WorkOrderList.poll();
}