class SomeOrderAdapter implements Order {
    private SomeOrder delegate;

    @Override
    public String getOrderId() {
        return delegate.getOrderId();
    }
}