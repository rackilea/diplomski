zoomBoxChkBox.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (e.getStateChange() == ItemEvent.SELECTED) {
            zoomPane = new ZoomPane(pane, true);
        } else {

            zoomPane = new ZoomPane(pane, false);
        }
    }
});