zoomBoxChkBox.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (e.getStateChange() == ItemEvent.SELECTED) {
            zoomPane.setShowZoomPopup(true);
        } else {
            zoomPane.setShowZoomPopup(false);
        }
    }
});