scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();
        System.out.println("Value: " + (scrollPane.getVerticalScrollBar().getValue()+extent) + " Max: " + scrollPane.getVerticalScrollBar().getMaximum());
    }
});