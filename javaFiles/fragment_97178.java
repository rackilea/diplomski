public synchronized WorkOrder getWorkOrder() {
    WorkOrder workOrder = null;

    try {
        while(mWorkOrderList.size() == 0) {
            this.wait();
        }

        mworkOrder = WorkOrderList.poll();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


    return workOrder;
}