private transient DataModel orderModel;

public DataModel getOrderModel() {
    if (orderModel == null) {
        orderModel = new ListDataModel(orderList);
    }
    return orderModel;
}