@PrepareForTest(Dispute.class)
public void testProcessChargebackUpdates() {
    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }
}