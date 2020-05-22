...
MySB sb = new MySB(orient, 0, 100, 0, 1000, true);
sb.addAdjustmentListener(new AdjustmentListener() {
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println(e.getValue()+", "+((MySB)e.getAdjustable()).getMyValue());
    }
});
...